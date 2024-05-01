package epita.fr.exercise_2;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer
        extends Reducer<Text, LongWritable, Text, LongWritable> {

    private final LongWritable result = new LongWritable();

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context)
            throws IOException, InterruptedException {
        long sum = 0;
        // Sum up the counts for the same word
        for (LongWritable val : values) {
            sum += val.get();
        }
        // Emit the word and its total count
        result.set(sum);
        context.write(key, result);
    }
}
