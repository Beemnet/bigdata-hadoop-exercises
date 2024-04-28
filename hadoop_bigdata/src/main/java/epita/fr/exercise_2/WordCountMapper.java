package epita.fr.exercise_2;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

    private final static LongWritable one = new LongWritable(1);
    private final Text word = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Split the line into words
        String[] words = value.toString().trim().split("\\s+");

        // Emit each word with a count of 1
        for (String w : words) {
            word.set(w.toLowerCase()); // Convert to lowercase to treat words like "Hadoop" and "hadoop" the same
            context.write(word, one);
        }
    }
}
