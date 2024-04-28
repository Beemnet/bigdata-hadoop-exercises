package epita.fr.exercise_4;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PM10ZoneMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Split the input line into fields: zoneId, date, pm10Value
        String[] fields = value.toString().split("\\s*,\\s*");

        // Extract zoneId, date, and pm10Value from the fields
        String zoneId = fields[0];
        String date = fields[1];
        double pm10Value = Double.parseDouble(fields[2]);

        // Emit key-value pair with zoneId as key and date as value
        if (pm10Value > 50.0) { // Check if PM10 value exceeds threshold
            context.write(new Text(zoneId), new Text(date));
        }
    }
}
