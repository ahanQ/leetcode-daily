package D367;

/**
 * @author luliuquan
 * @date 2021/11/4 9:58
 */
public class D367 {
    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(16));
        System.out.println(new Solution().isPerfectSquare(14));
        System.out.println(new Solution().isPerfectSquare(808201));
    }
}
class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = Math.min(num / 2, 46340);
        while (l < r) {
            int m = (l + r) / 2;
            if (m * m < num) {
                l = m + 1;
            } else if (m * m > num) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return l * l == num;
    }
}