package epita.fr.exercise_4;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PM10ZoneMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Split the input line into fields: zoneId, date, pm10Value
        String[] parts = value.toString().split(",");
        String[] fields = parts[1].split("\\s+");

        // Extract zoneId, date, and pm10Value from the fields
        String zoneId = parts[0].trim();
        String date = fields[0].trim();
        double pm10Value = Double.parseDouble(fields[1].trim());

        // Emit key-value pair with zoneId as key and date as value
        if (pm10Value > 50.0) { // Check if PM10 value exceeds threshold
            context.write(new Text(zoneId), new Text(date));
        }
    }
}
