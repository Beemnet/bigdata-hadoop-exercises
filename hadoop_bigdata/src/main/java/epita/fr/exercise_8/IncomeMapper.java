package epita.fr.exercise_8;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class IncomeMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] parts = value.toString().split("\\s+");
        String[] dateParts = parts[0].split("-");
        String monthYear = dateParts[0] + "-" + dateParts[1];
        int dailyIncome = Integer.parseInt(parts[1]);
        context.write(new Text(monthYear), new IntWritable(dailyIncome));
    }
}
