package D1218;

/**
 * @author luliuquan
 * @date 2021/11/5 9:01
 */
public class D1218 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println(new Solution().longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        System.out.println(new Solution().longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));

    }
}

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] t = new int[40001];
        int d = 20000;
        int max = 1;
        for (int a : arr) {
            t[a + d] = t[a + d - difference] + 1;
            max = Math.max(max, t[a + d]);
        }
        return max;
    }
}