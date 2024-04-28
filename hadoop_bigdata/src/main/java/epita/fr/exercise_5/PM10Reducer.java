package epita.fr.exercise_5;
import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class PM10Reducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {

    @Override
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {
        double sum = 0.0;
        int count = 0;
        for (DoubleWritable value : values) {
            sum += value.get();
            count++;
        }
        double average = sum / count;
        context.write(key, new DoubleWritable(average));
    }
}
