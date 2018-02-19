import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class VoteCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    public VoteCountReducer() {
    }

    public void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context output) throws IOException, InterruptedException {
        int voteCount = 0;

        IntWritable value;
        for(Iterator var5 = values.iterator(); var5.hasNext(); voteCount += value.get()) {
            value = (IntWritable)var5.next();
        }

        output.write(key, new IntWritable(voteCount));
    }
}
