/**
 * 十进制整数的反码
 *
 * @author luliuquan
 * @date 2019/12/17 22:30
 */
public class D1009 {
    public static void main(String[] args) {
        System.out.println(new D1009().new Solution().bitwiseComplement(10));
    }

    class Solution {
        public int bitwiseComplement(int N) {
            if (N == 0) {
                return 1;
            }
            int count = 0;
            while (N > 0) {
                N <<= 1;
                count++;
            }

            for (int i = count; i > 0; i--) {
                N >>= 1;
            }
            return ~N;
        }
    }
}