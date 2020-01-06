import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 删列造序
 *
 * @author luliuquan
 * @date 2019年12月30日
 */
public class D944 {
    public static void main(String[] args) {
        Path path = Paths.get(".\\in\\" + D944.class.getSimpleName());
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                new SolutionWarp().minDeletionSize(line.split(","));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SolutionWarp extends Solution {
        @Override
        public int minDeletionSize(String[] A) {
            long start = System.currentTimeMillis();
            int result = super.minDeletionSize(A);
            long end = System.currentTimeMillis();
            System.out.printf("A: %s%n", String.join(",", A));
            System.out.printf("time: %s result: %s%n", (end - start), result);
            return result;
        }
    }

    /**
     *
     */
    static
    class Solution {
        public int minDeletionSize(String[] A) {
            char[][] a = new char[A.length][];
            for (int i = 0; i < A.length; i++) {
                a[i] = A[i].toCharArray();
            }
            int result = 0;
            for (int column = 0; column < A[0].length(); column++) {
                for (int row = 1; row < A.length; row++) {
                    if (a[row][column] < a[row - 1][column]) {
                        result++;
                        break;
                    }
                }
            }
            return result;
        }
    }
}