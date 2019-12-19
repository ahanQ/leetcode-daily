import java.util.Arrays;

/**
 * 组合总和 Ⅳ
 *
 * @author luliuquan
 * @date 2019年12月19日
 */
@SuppressWarnings("ALL")
public class D377 {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum4(new int[]{2, 5, 3}, 35));
    }

    /**
     * 递归 超时
     */
//    static
//    class Solution {
//        public int combinationSum4(int[] nums, int target) {
//            Arrays.sort(nums);
//            return resolve(nums, target);
//        }
//
//        private int resolve(int[] nums, int target) {
//            int count = 0;
//            for (int num : nums) {
//                if (target == num) {
//                    count += 1;
//                } else if (target > num) {
//                    count += resolve(nums, target - num);
//                }
//                if (target <= num) {
//                    break;
//                }
//            }
//            return count;
//        }
//    }

    /**
     * 加缓存递归
     */
//    static
//    class Solution {
//        public int combinationSum4(int[] nums, int target) {
//            Arrays.sort(nums);
//            buffered = new int[target + 1];
//            Arrays.fill(buffered, -1);
//            return resolve(nums, target);
//        }
//
//        private int[] buffered;
//
//        private int resolve(int[] nums, int target) {
//            int count = 0;
//            for (int num : nums) {
//                if (target == num) {
//                    count += 1;
//                } else if (target > num) {
//                    if (buffered[target - num] == -1) {
//                        buffered[target - num] = resolve(nums, target - num);
//                    }
//                    count += buffered[target - num];
//
//                }
//                if (target <= num) {
//                    break;
//                }
//            }
//            return count;
//        }
//    }
    /**
     * 动态规划
     */
    static
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            Arrays.sort(nums);
            buffered = new int[target + 1];
            buffered[0] = 1;
            return resolve(nums, target);
        }

        private int[] buffered;

        private int resolve(int[] nums, int target) {
            for (int i = 0; i <= target; i++) {
                for (int num : nums) {
                    if (i + num <= target) {
                        buffered[i + num] += buffered[i];
                    }
                }
            }
            return buffered[target];
        }
    }
}