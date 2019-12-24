import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 跳跃游戏 II
 *
 * @author luliuquan
 * @date 2019年12月24日
 */
public class D45 {
    public static void main(String[] args) {
        Path path = Paths.get(".\\in\\" + D45.class.getSimpleName());
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] split = line.split("[ ]*,[ ]*");
                int[] array = Arrays.stream(split).mapToInt(Integer::valueOf).toArray();
                new SolutionWarp().jump(array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SolutionWarp extends Solution {
        @Override
        public int jump(int[] nums) {
            System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(",")));
            long start = System.currentTimeMillis();
            int result = super.jump(nums);
            long end = System.currentTimeMillis();
            System.out.printf("time: %s result:%s\n", (end - start), result);
            return result;
        }
    }

    /**
     * 不知道什么法，这是我的解法，应该是O(n2)的时间复杂度。
     */
//    static
//    class Solution {
//        public int jump(int[] nums) {
//            int[] cache;
//            cache = new int[nums.length];
//            Arrays.fill(cache, Integer.MAX_VALUE - 1);
//            cache[cache.length - 1] = 0;
//            for (int i = nums.length - 2; i >= 0; --i) {
//                int step = nums[i];
//                int times = Integer.MAX_VALUE - 1;
//                for (int j = i + 1; j <= i + step && j < nums.length; j++) {
//                    times = Math.min(cache[j] + 1, times);
//                }
//                cache[i]= times;
//            }
//            return cache[0];
//        }
//    }

    /**
     * 贪心算法，参考别人的算法，时间复杂度O(n)。
     */
    static
    class Solution {
        public int jump(int[] nums) {
            int end = 0;
            int maxPosition = 0;
            int steps = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                //找能跳的最远的
                maxPosition = Math.max(maxPosition, nums[i] + i);
                if (i == end) { //遇到边界，就更新边界，并且步数加一
                    end = maxPosition;
                    steps++;
                }
            }
            return steps;
        }
    }
}