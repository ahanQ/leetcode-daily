import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 划分数组为连续数字的集合
 *
 * @author luliuquan
 * @date 2020年1月15日
 */
public class D154 {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        Path path = Paths.get(".\\in\\" + D154.class.getSimpleName());
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                List<Integer> in = objectMapper.readValue(line, new TypeReference<List<Integer>>() {
                });
                new SolutionWarp().findMin(in.stream().mapToInt(Integer::intValue).toArray());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SolutionWarp extends Solution {
        @Override
        public int findMin(int[] nums) {
            long start = System.currentTimeMillis();
            int result = super.findMin(nums);
            long end = System.currentTimeMillis();
            try {
                System.out.printf("rooms: %s %n", objectMapper.writeValueAsString(nums));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.printf("time: %s result: %s%n", (end - start), result);
            return result;
        }
    }

    /**
     * 直接求解。时间复杂度 O(N)
     */
    static
    class Solution1 {
        public int findMin(int[] nums) {
            int min = nums[0];
            for (int num : nums) {
                min = Math.min(min, num);
            }
            return min;
        }
    }

    /**
     * 二分法
     */
    static
    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    right = right - 1;
                }
            }
            return nums[left];
        }
    }
}