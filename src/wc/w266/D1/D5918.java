package wc.w266.D1;

/**
 * @author luliuquan
 * @date 2021/11/7 10:30
 */
public class D5918 {
    public static void main(String[] args) {
        System.out.println(new Solution().countVowelSubstrings("aeiouu"));
        System.out.println(new Solution().countVowelSubstrings("unicornarihan"));
        System.out.println(new Solution().countVowelSubstrings("cuaieuouac"));
        System.out.println(new Solution().countVowelSubstrings("bbaeixoubb"));
    }
}

class Solution {
    public int countVowelSubstrings(String word) {
        final char[] chars = word.toCharArray();
        int l = 0;
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!valid(chars[i])) {
                sum += this.countVowelSubstrings(chars, l, i - 1);
                l = i + 1;
            }
        }
        if (l + 4 <= chars.length) {
            sum += this.countVowelSubstrings(chars, l, chars.length - 1);
        }
        return sum;
    }

    public int countVowelSubstrings(char[] word, int s, int e) {
        final int[] t = new int[128];
        int sum = 0;
        int l = s;
        for (int i = s, tmpSum = e - s + 1; i <= e; i++, tmpSum--) {
            t[word[i]]++;
            while (t['a'] > 0 && t['e'] > 0 && t['i'] > 0 && t['o'] > 0 && t['u'] > 0) {
                sum += tmpSum;
                t[word[l++]]--;
            }
        }
        return sum;
    }

    private boolean valid(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}