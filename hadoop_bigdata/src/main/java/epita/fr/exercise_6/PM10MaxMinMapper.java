package epita.fr.exercise_6;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class PM10MaxMinMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] parts = value.toString().split(",");
        String sensorId = parts[0];
        double pm10Value = Double.parseDouble(parts[2]);
        context.write(new Text(sensorId), new Text("max=" + pm10Value + "_min=" + pm10Value));
    }
}
