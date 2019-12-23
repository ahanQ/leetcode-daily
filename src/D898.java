import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 子数组按位或操作
 *
 * @author luliuquan
 * @date 2019年12月23日
 */
public class D898 {
    public static void main(String[] args) {
        Path path = Paths.get(".\\in\\898.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] split = line.split("[ ]*,[ ]*");
                int[] array = Arrays.stream(split).mapToInt(Integer::valueOf).toArray();
                new SolutionWarp().subarrayBitwiseORs(array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SolutionWarp extends Solution {
        @Override
        public int subarrayBitwiseORs(int[] A) {
            long start = System.currentTimeMillis();
            int result = super.subarrayBitwiseORs(A);
            long end = System.currentTimeMillis();
            System.out.printf("time: %s result:%s\n", (end - start), result);
            return result;
        }
    }

    /**
     * 不知道什么法
     */
    static
    class Solution {
        public int subarrayBitwiseORs(int[] A) {
            Set<Integer> sum = new HashSet<>();
            int length = A.length;
            for (int value : A) {
                sum.add(value);
            }
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < length - i; j++) {
                    if (A[j] == A[j + 1]) {
                        System.arraycopy(A, j + 1, A, j, length - j - 1);
                        j--;
                        length--;
                        continue;
                    }
                    sum.add(A[j] |= A[j + 1]);
                }
            }
            return sum.size();
        }
    }
}