package epita.fr.exercise_5;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class PM10Mapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] parts = value.toString().split(",");
        String sensorId = parts[0];
        double pm10Value = Double.parseDouble(parts[2]);
        context.write(new Text(sensorId), new DoubleWritable(pm10Value));
    }
}