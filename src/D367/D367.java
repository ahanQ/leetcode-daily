package D367;

/**
 * @author luliuquan
 * @date 2021/11/4 9:58
 */
public class D367 {
    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(16));
        System.out.println(new Solution().isPerfectSquare(14));
    }
}
class Solution {
    public boolean isPerfectSquare(int num) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            final int x = i * i;
            if (x == num) {
                return true;
            }
            if (x > num) {
                return false;
            }
        }
        return false;
    }
}