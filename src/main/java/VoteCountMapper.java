import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class VoteCountMapper extends Mapper<Object, Text, Text, IntWritable> {

    private static final IntWritable one = new IntWritable(1);

    public void map(Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context output) throws IOException, InterruptedException {
        //si hay más de una palabra se separa por espacio
        String[] words = value.toString().split(" ");
        // solo se toma en cuenta la primera palabra
        output.write(new Text(words[0]), one);
    }
}
