package epita.fr.exercise_4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PM10ZoneReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        List<String> datesAboveThreshold = new ArrayList<>();

        // Collect the dates where PM10 value exceeds threshold
        for (Text value : values) {
            datesAboveThreshold.add(value.toString());
        }

        // Emit key-value pair with zoneId as key and list of dates as value
        context.write(key, new Text(datesAboveThreshold.toString()));
    }
}
