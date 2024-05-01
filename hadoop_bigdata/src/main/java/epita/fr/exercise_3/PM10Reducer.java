package epita.fr.exercise_3;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PM10Reducer extends Reducer<Text, Text, Text, LongWritable> {

    private static final double THRESHOLD = 50.0; // Threshold for PM10 value

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        long daysAboveThreshold = 0;

        for (Text value : values) {
            String[] fields = value.toString().split(",");
            double pm10Value = Double.parseDouble(fields[1]);

            if (pm10Value > THRESHOLD) {
                daysAboveThreshold++;
            }
        }

        context.write(key, new LongWritable(daysAboveThreshold));
    }
}
