import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 分汤
 *
 * @author luliuquan
 * @date 2020年1月8日
 */
public class D808 {
    public static void main(String[] args) {
        Path path = Paths.get(".\\in\\" + D808.class.getSimpleName());
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                new SolutionWarp().soupServings(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SolutionWarp extends Solution {
        @Override
        public double soupServings(int N) {
            long start = System.currentTimeMillis();
            double result = super.soupServings(N);
            long end = System.currentTimeMillis();
            System.out.printf("N: %s%n", N);
            System.out.printf("time: %s result: %s%n", (end - start), result);
            return result;
        }
    }

    /**
     * 动态规划、记忆缓存、修剪。
     */
    static
    class Solution {
        private double[][] cache;

        public double soupServings(int N) {
            if(N > 4500) {
                return 1;
            }
            N = N / 25 + (N % 25 > 0 ? 1 : 0);
            cache = new double[N + 1][N + 1];
            return s(N, N);
        }

        private double s(int a, int b) {
            if (a <= 0 && b <= 0) {
                return .5;
            }
            if (a <= 0) {
                return 1;
            }
            if (b <= 0) {
                return 0;
            }
            if (cache[a][b] != 0) {
                return cache[a][b];
            }
            double v = 0.25 * (s(a - 4, b) + s(a - 3, b - 1) + s(a - 2, b - 2) + s(a - 1, b - 3));
            cache[a][b] = v;
            return v;
        }
    }
}