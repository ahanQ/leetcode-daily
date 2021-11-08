package wc.w266.D2;

/**
 * @author luliuquan
 * @date 2021/11/7 10:34
 */
public class D5919 {
    public static void main(String[] args) {
        System.out.println(new Solution().countVowels("aeiou"));
        System.out.println(new Solution().countVowels("aba"));
        System.out.println(new Solution().countVowels("abc"));
        System.out.println(new Solution().countVowels("ltcd"));
        System.out.println(new Solution().countVowels("noosabasboosa"));
    }
}

class Solution {
    public long countVowels(String word) {
        final char[] chars = word.toCharArray();
        long sum = 0;
        long length = chars.length;
        final long tSum = length * (length + 1) / 2;
        for (long i = 0; i < chars.length; i++) {
            if (valid(chars[(int) i])) {
                long minC = Math.min(i, length - i - 1);
                long maxC = length - minC - 1;
                sum += tSum;
                sum -= maxC * (maxC + 1) / 2;
                sum -= minC * (minC + 1) / 2;
            }
        }
        return sum;
    }

    private boolean valid(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}