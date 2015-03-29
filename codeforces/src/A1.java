import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by weixing on 3/29/2015.
 */
public class A1 {
    public static void main(String[] args) throws IOException {
        String line = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (System.in));
        while ((line = reader.readLine()) != null) {
            String[] strs = line.split(" ");
            assert strs.length == 3;
            long m = Long.parseLong(strs[0]);
            long n = Long.parseLong(strs[1]);
            long a = Long.parseLong(strs[2]);
            System.out.println(((m + a - 1) / a) * ((n + a - 1) / a));
        }
    }
}
