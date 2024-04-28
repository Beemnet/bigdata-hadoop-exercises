package epita.fr.exercise_7;

import java.io.IOException;
import java.util.HashSet;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class InvertedIndexReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        HashSet<String> sentenceIds = new HashSet<>();
        for (Text value : values) {
            sentenceIds.add(value.toString());
        }
        context.write(key, new Text(sentenceIds.toString()));
    }
}
