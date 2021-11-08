package wc.w266.D3;

/**
 * @author luliuquan
 * @date 2021/11/7 10:37
 */
public class D5920 {
    public static void main(String[] args) {
        System.out.println(new Solution().minimizedMaximum(6, new int[]{11, 6}));
        System.out.println(new Solution().minimizedMaximum(7, new int[]{15, 10, 10}));
        System.out.println(new Solution().minimizedMaximum(1, new int[]{10000}));

    }
}

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int[] t = new int[n];
        int sum = 0;
        int max = 0;
        for (int q : quantities) {
            sum += q;
            max = Math.max(max, q);
        }

        int min = sum / n + (sum % n == 0 ? 0 : 1);
        while (min < max) {
            int mid = (min + max) / 2;
            int c = 0;
            for (int q : quantities) {
                c += q / mid + (q % mid == 0 ? 0 : 1);
            }
            if (c <= n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}