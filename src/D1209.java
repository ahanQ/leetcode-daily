import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * 删除字符串中的所有相邻重复项 II
 *
 * @author luliuquan
 * @date 2020年1月9日
 */
public class D1209 {
    public static void main(String[] args) {
        Path path = Paths.get(".\\in\\" + D1209.class.getSimpleName());
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] s = line.split(" ");
                new SolutionWarp().removeDuplicates(s[0], Integer.parseInt(s[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SolutionWarp extends Solution {
        @Override
        public String removeDuplicates(String s, int k) {
            long start = System.currentTimeMillis();
            String result = super.removeDuplicates(s, k);
            long end = System.currentTimeMillis();
            System.out.printf("s: %s k:%s%n", s, k);
            System.out.printf("time: %s result: %s%n", (end - start), result);
            return result;
        }
    }

    /**
     * 直接求解。
     */
    static
    class Solution1 {

        public String removeDuplicates(String s, int k) {
            StringBuilder temp = new StringBuilder();
            StringBuilder result = new StringBuilder(s);
            do {
                temp.setLength(0);
                temp.append(result.toString());
                result.setLength(0);
                for (int i = 0; i < temp.length(); ) {
                    int start = i;
                    int end;
                    for (end = start + 1; end < start + k; end++) {
                        if (end >= temp.length() || temp.charAt(end) != temp.charAt(end - 1)) {
                            break;
                        }
                    }
                    if (end - start != k) {
                        result.append(temp.subSequence(start, end));
                    }
                    i = end;
                }
            } while (!Objects.equals(temp.toString(), result.toString()));
            return result.toString();
        }

    }

    /**
     * 栈求解。
     */
    static
    class Solution {
        public String removeDuplicates(String s, int k) {
            StringBuilder result = new StringBuilder();
            char[] chars = s.toCharArray();
            int[][] cache = new int[10000][2];
            int cacheSize = -1;
            for (char c : chars) {
                result.append(c);
                if (cacheSize >= 0 && cache[cacheSize][0] == c) {
                    cache[cacheSize][1] += 1;
                    if (cache[cacheSize][1] == k) {
                        cacheSize--;
                        result.setLength(result.length() - k);
                    }
                } else {
                    cacheSize++;
                    cache[cacheSize][0] = c;
                    cache[cacheSize][1] = 1;
                }
            }
            return result.toString();
        }
    }
}