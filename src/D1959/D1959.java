package D1959;

/**
 * @author luliuquan
 * @date 2021/11/2 9:30
 */
public class D1959 {
    public static void main(String[] args) {
        System.out.println(new Solution().minSpaceWastedKResizing(new int[]{10, 20}, 0));
        System.out.println(new Solution().minSpaceWastedKResizing(new int[]{10, 20, 30}, 1));
        System.out.println(new Solution().minSpaceWastedKResizing(new int[]{10, 20, 15, 30, 20}, 2));
        System.out.println(new Solution().minSpaceWastedKResizing(new int[]{38, 28, 3, 2, 6, 14, 15, 33, 39}, 1));
        System.out.println(new Solution().minSpaceWastedKResizing(new int[]{10, 20, 15, 30, 20}, 2));
        System.out.println(new Solution().minSpaceWastedKResizing(new int[]{13, 46, 42, 45, 35}, 4));
        System.out.println(new Solution().minSpaceWastedKResizing(new int[]{52, 668, 554, 857, 16, 993, 96, 949, 772, 870, 243, 171, 417, 498, 493, 219, 886, 411, 925, 61, 169, 389, 3, 400, 272, 949, 803, 804, 466, 293, 434, 714, 981, 749, 803, 570, 678, 736, 499, 159, 195, 304, 223, 992, 60, 594}, 6));
    }
}

class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            int curMax = nums[i];
            int sum = curMax;
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                curMax = Math.max(curMax, nums[j]);
                g[i][j] = curMax * (j - i + 1) - sum;
            }
        }
        // dp[i][j] 表示[0, i] 划分为j段的浪费数量
        // 即每段过度时，都会消耗一次调整机会将容量调整到下一段的最大值
        int[][] dp = new int[n][k + 2]; // k次机会可以形成k+1段
        for (int i = 0; i < n; i++) {
            dp[i][1] = g[0][i];
            for (int j = 2; j < k + 2 && j <= i + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE >> 1;
                for (int i0 = j - 2; i0 < i; i0++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i0][j - 1] + g[i0 + 1][i]);
                }
            }
        }
        return dp[n - 1][k + 1];
    }
}