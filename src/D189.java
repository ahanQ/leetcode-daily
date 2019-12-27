import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 旋转数组
 *
 * @author luliuquan
 * @date 2019年12月27日
 */
public class D189 {
    public static void main(String[] args) {
        Path path = Paths.get(".\\in\\" + D189.class.getSimpleName());
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                int[] split = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
                int[] nums = Arrays.copyOfRange(split, 0, split.length - 1);
                int k = split[split.length - 1];
                new SolutionWarp().rotate(nums, k);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SolutionWarp extends Solution {
        @Override
        public void rotate(int[] nums, int k) {
//            long start = System.currentTimeMillis();
            super.rotate(nums, k);
//            long end = System.currentTimeMillis();
//            System.out.printf("time: %s", (end - start));
        }
    }

    /**
     * 普通
     */
//    static
//    class Solution {
//        public void rotate(int[] nums, int k) {
//            long start = System.currentTimeMillis();
//            k = k % nums.length;
//            if (2 * k < nums.length) {
//                for (int i = 0; i < k; i++) {
//                    int a = nums[nums.length - 1];
//                    System.arraycopy(nums, 0, nums, 1, nums.length - 1);
//                    nums[0] = a;
//                }
//            } else {
//                for (int i = 0; i < nums.length - k; i++) {
//                    int a = nums[0];
//                    System.arraycopy(nums, 1, nums, 0, nums.length - 1);
//                    nums[nums.length - 1] = a;
//                }
//            }
//            long end = System.currentTimeMillis();
//            System.out.printf("time: %s\n", (end - start));
//            System.out.println(Arrays.stream(nums).boxed().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
//        }
//    }

    /**
     * 反转法，最棒。
     */
    static
    public class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

}