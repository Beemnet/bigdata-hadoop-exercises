package epita.fr.exercise_3;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PM10Mapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        // Split the input line by comma then by tab
        String[] parts = value.toString().split(",");
        String[] fields = parts[1].split("\\s+");

        // Extract sensorId, date, and pm10Value from the fields
        String sensorId = parts[0].trim();
        String date = fields[0].trim();
        double pm10Value = Double.parseDouble(fields[1].trim());

        // Emit key-value pair with sensorId as key and date, pm10Value as value
        context.write(new Text(sensorId), new Text(date + "," + pm10Value));
    }
}
