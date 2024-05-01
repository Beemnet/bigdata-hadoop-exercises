package epita.fr.exercise_1;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    private final static LongWritable ONE = new LongWritable(1);
    private Text word = new Text();

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] words = value.toString().split("\\s+");
        for (String w : words) {
            w = w.replaceAll("\\.", "");
            word.set(w);
            context.write(word, ONE);
        }
    }
}
