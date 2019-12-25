import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 *
 * @author luliuquan
 * @date 2019年12月25日
 */
public class D93 {
    public static void main(String[] args) {
        Path path = Paths.get(".\\in\\" + D93.class.getSimpleName());
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                new SolutionWarp().restoreIpAddresses(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SolutionWarp extends Solution {
        @Override
        public List<String> restoreIpAddresses(String s) {
            System.out.println(s);
            long start = System.currentTimeMillis();
            List<String> result = super.restoreIpAddresses(s);
            long end = System.currentTimeMillis();
            System.out.printf("time: %s result:%s\n", (end - start), result);
            return result;
        }
    }

    /**
     * 真 暴力法
     */
    static
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            int length = s.length();
            List<String> result = new ArrayList<>();
            for (int i = 1; i <= 3; ++i)
                for (int j = i + 1; j <= i + 3; ++j)
                    for (int k = j + 1; k <= j + 3; ++k) {
                        if (length - 1 < k || k < length - 3) continue;
                        int s1 = Integer.parseInt(s.substring(0, i));
                        int s2 = Integer.parseInt(s.substring(i, j));
                        int s3 = Integer.parseInt(s.substring(j, k));
                        int s4 = Integer.parseInt(s.substring(k));
                        if (s1 <= 255 && s2 <= 255 && s3 <= 255 && s4 <= 255) {
                            String ip = String.format("%s.%s.%s.%s", s1, s2, s3, s4);
                            if (ip.length() == length + 3) result.add(ip);
                        }
                    }
            return result;
        }
    }

}