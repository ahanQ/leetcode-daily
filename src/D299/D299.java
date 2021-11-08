package D299;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luliuquan
 * @date 2021/11/8 9:02
 */
public class D299 {
    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1807", "7810"));
        System.out.println(new Solution().getHint("1123", "0111"));
        System.out.println(new Solution().getHint("1", "0"));
        System.out.println(new Solution().getHint("1", "1"));
        System.out.println(new Solution().getHint("1122", "2211"));
    }
}

class Solution {
    public String getHint(String secret, String guess) {
        List<Character> s = new ArrayList<>();
        List<Character> g = new ArrayList<>();
        int a = 0, b = 0;
        final char[] secrets = secret.toCharArray();
        final char[] guesses = guess.toCharArray();
        for (int i = 0; i < secrets.length; i++) {
            if (secrets[i] == guesses[i]) {
                a++;
                continue;
            }
            s.add(secrets[i]);
            g.add(guesses[i]);
        }
        for (Character c : g) {
            if (s.contains(c)) {
                b++;
                s.remove(s.lastIndexOf(c));
            }
        }
        return a + "A" + b + "B";
    }
}