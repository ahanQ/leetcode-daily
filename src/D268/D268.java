package D268;

import java.util.Arrays;

/**
 * @author luliuquan
 * @date 2021/11/6 22:17
 */
public class D268 {
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{3, 0, 1}));
        System.out.println(new Solution().missingNumber(new int[]{0, 1}));
        System.out.println(new Solution().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(new Solution().missingNumber(new int[]{0}));
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}