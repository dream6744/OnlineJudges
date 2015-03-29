import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by weixing on 3/29/2015.
 */
public class B1 {
    public static Pattern CELL_NO_PATTERN = Pattern.compile("R(\\d+)C(\\d+)");
    public static Pattern CELL_STR_PATTERN = Pattern.compile("([A-Z]+)(\\d+)");

    public static String toCellStr(Matcher matcher) {
        String rowNo = matcher.group(1);
        String colNo = matcher.group(2);
        return toStr(Integer.parseInt(colNo)) + rowNo;
    }

    public static String toCellNo(Matcher matcher) {
        String colNo = matcher.group(1);
        String rowNo = matcher.group(2);
        return "R" + rowNo + "C" + toNum(colNo);
    }

    public static String toStr(int n) {
        String ret = "";
        while (n != 0) {
            int m = n % 26;
            n /= 26;
            if (m == 0) {
                m = 26;
                --n;
            }
            ret = ((char) (m + 'A' - 1)) + ret;
        }
        return ret;
    }

    public static int toNum(String str) {
        int n = 0;
        for (int i = 0; i < str.length(); ++i) {
            n *= 26;
            n += (str.charAt(i) - 'A' + 1);
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; ++i) {
            String line = reader.readLine();
            Matcher matcher = CELL_NO_PATTERN.matcher(line);
            if (matcher.find()) {
                System.out.println(toCellStr(matcher));
            } else {
                matcher = CELL_STR_PATTERN.matcher(line);
                if (matcher.find()) {
                    System.out.println(toCellNo(matcher));
                }
            }
        }
    }
}
