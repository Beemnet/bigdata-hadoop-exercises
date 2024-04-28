package epita.fr.exercise_8;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class IncomeReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {

    private Map<String, Integer> monthTotalIncomeMap;
    private Map<String, Integer> yearTotalIncomeMap;

    @Override
    public void setup(Context context) throws IOException, InterruptedException {
        monthTotalIncomeMap = new HashMap<>();
        yearTotalIncomeMap = new HashMap<>();
    }

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int totalIncome = 0;
        for (IntWritable value : values) {
            totalIncome += value.get();
        }
        String[] parts = key.toString().split("-");
        String month = parts[0] + "-" + parts[1];
        String year = parts[0];

        // Calculate total income for each month
        monthTotalIncomeMap.put(month, monthTotalIncomeMap.getOrDefault(month, 0) + totalIncome);
        
        // Calculate total income for each year
        yearTotalIncomeMap.put(year, yearTotalIncomeMap.getOrDefault(year, 0) + totalIncome);
    }

    @Override
    public void cleanup(Context context) throws IOException, InterruptedException {
        // Output total income for each month
        for (Map.Entry<String, Integer> entry : monthTotalIncomeMap.entrySet()) {
            context.write(new Text(entry.getKey()), new DoubleWritable(entry.getValue()));
        }

        // Calculate average monthly income per year
        for (Map.Entry<String, Integer> entry : yearTotalIncomeMap.entrySet()) {
            int totalIncome = entry.getValue();
            int numMonths = 0;
            String year = entry.getKey();
            for (Map.Entry<String, Integer> monthEntry : monthTotalIncomeMap.entrySet()) {
                if (monthEntry.getKey().startsWith(year) && monthEntry.getValue() > 0) {
                    numMonths++;
                }
            }
            if (numMonths > 0) {
                double averageIncome = (double) totalIncome / numMonths;
                context.write(new Text(year), new DoubleWritable(averageIncome));
            }
        }
    }
}
