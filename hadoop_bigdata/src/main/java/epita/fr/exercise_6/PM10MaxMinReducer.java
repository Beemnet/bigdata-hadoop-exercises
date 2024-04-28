package epita.fr.exercise_6;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class PM10MaxMinReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (Text value : values) {
            String[] parts = value.toString().split("_");
            double currentValue = Double.parseDouble(parts[0].substring(4));
            max = Math.max(max, currentValue);
            min = Math.min(min, currentValue);
        }
        context.write(key, new Text("max=" + max + "_min=" + min));
    }
}
