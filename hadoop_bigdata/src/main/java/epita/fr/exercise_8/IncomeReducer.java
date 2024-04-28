package epita.fr.exercise_8;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class IncomeReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int totalIncome = 0;
        int count = 0;
        for (IntWritable value : values) {
            totalIncome += value.get();
            count++;
        }
        if (totalIncome > 0) {
            double averageIncome = (double) totalIncome / count;
            context.write(key, new DoubleWritable(averageIncome));
        }
    }
}
