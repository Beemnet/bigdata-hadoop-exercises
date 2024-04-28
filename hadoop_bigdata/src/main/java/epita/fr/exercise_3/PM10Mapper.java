package epita.fr.exercise_3;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PM10Mapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Split the input line into fields: sensorId, date, pm10Value
        String[] fields = value.toString().split("\\s*,\\s*");

        // Extract sensorId, date, and pm10Value from the fields
        String sensorId = fields[0];
        String date = fields[1];
        double pm10Value = Double.parseDouble(fields[2]);

        // Emit key-value pair with sensorId as key and date, pm10Value as value
        context.write(new Text(sensorId), new Text(date + "," + pm10Value));
    }
}
