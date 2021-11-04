package wc.w265.D1;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，返回 nums 中满足 i mod 10 == nums[i] 的最小下标 i ；如果不存在这样的下标，返回 -1 。
 * x mod y 表示 x 除以 y 的 余数 。
 *
 * @author luliuquan
 * @date 2021/11/4 11:06
 */
public class D1 {
    public static void main(String[] args) {
        System.out.println(new Solution().smallestEqual(new int[]{7, 8, 3, 5, 2, 6, 3, 1, 1, 4, 5, 4, 8, 7, 2, 0, 9, 9, 0, 5, 7, 1, 6}));
    }
}
class Solution {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}