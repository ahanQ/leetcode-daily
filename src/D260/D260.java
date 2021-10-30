package D260;

import java.util.Arrays;

/**
 * @author luliuquan
 * @date 2021/10/30 16:41
 */
public class D260 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[]{0, 0, 1, 2})));
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[]{1403617094, -490450406, -1756388866, -967931676, 1878401007, 1878401007, -74743538, 1403617094, -1756388866, -74743538, -490450406, -1895772685})));
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
        int index = 2;
        if (nums.length == 2) {
            return nums;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[a] == nums[b]) {
                swap(nums, a, index++);
                swap(nums, b, index++);
                i = index - 1;
            } else if (nums[a] == nums[i]) {
                swap(nums, i, index++);
                swap(nums, a, index++);
                i = index - 1;
            } else if (nums[b] == nums[i]) {
                swap(nums, i, index++);
                swap(nums, b, index++);
                i = index - 1;
            }
        }
        return Arrays.copyOfRange(nums, 0, 2);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
