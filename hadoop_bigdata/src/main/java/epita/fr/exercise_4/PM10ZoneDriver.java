package epita.fr.exercise_4;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class PM10ZoneDriver {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "PM10 pollution analysis per city zone");

        job.setJarByClass(PM10ZoneDriver.class);
        job.setMapperClass(PM10ZoneMapper.class);
        job.setReducerClass(PM10ZoneReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        // Input and Output formats
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        // Set input and output paths
        TextInputFormat.addInputPath(job, new Path("hadoop_bigdata/src/main/java/epita/fr/exercise_4/input")); // Input path
        TextOutputFormat.setOutputPath(job, new Path("hadoop_bigdata/src/main/java/epita/fr/exercise_4/output")); // Output path

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
