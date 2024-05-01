package epita.fr.exercise_7;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class InvertedIndexMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] parts = value.toString().trim().split("\\t");
        if (parts.length >= 2) {
            String[] words = parts[1].split("\\s+");
            String sentenceId = parts[0];

            for (String word : words) {
                // Ignore common words
                if (!word.equalsIgnoreCase("and") && !word.equalsIgnoreCase("or")
                        && !word.equalsIgnoreCase("not")) {
                    context.write(new Text(word.toLowerCase()), new Text(sentenceId));
                }
            }
        } else {
            // Handle malformed input
            System.err.println("Malformed input: " + value.toString());
        }
    }
}
