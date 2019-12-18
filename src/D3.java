/**
 * 无重复字符的最长子串
 *
 * @author luliuquan
 * @date 2019年12月18日
 */
public class D3 {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }

    static
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.isEmpty()) {
                return 0;
            }
            int[] cache = new int[256];
            char[] chars = s.toCharArray();
            int length = chars.length;
            int maxLength = 1;
            ++cache[chars[0]];
            for (int begin = 0, end = 1; end < length; ++end) {
                char a = chars[begin];
                char b = chars[end];
                ++cache[b];
                boolean lengthAdd = true;
                for (int c : cache) {
                    if (c > 1) {
                        lengthAdd = false;
                        break;
                    }
                }
                if (lengthAdd) {
                    ++maxLength;
                } else {
                    ++begin;
                    --cache[a];
                }
            }
            return maxLength;
        }
    }
}