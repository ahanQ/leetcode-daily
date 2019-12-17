/**
 * @author luliuquan
 * @date 2019/12/16 10:00
 */
public class D1128 {
    public static void main(String[] args) {
        int[][] dominoes = {{1,2}};
        System.out.println(new D1128().new Solution().numEquivDominoPairs(dominoes));
    }
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            int[] cache = new int[dominoes.length];
            int sum = 0;
            for(int i = 0; i < dominoes.length - 1; i++) {
                if(cache[i] != 0) {
                    continue;
                }
                cache[i] = 1;
                int[] domino1 = dominoes[i];
                int count = 1;
                for(int j = i + 1; j < dominoes.length; j++) {
                    int[] domino2 = dominoes[j];
                    if(domino1[0] == domino2[0] && domino1[1] == domino2[1]) {
                        count++;
                        cache[j] = 1;
                        continue;
                    }
                    if(domino1[0] == domino2[1] && domino1[1] == domino2[0]) {
                        count++;
                        cache[j] = 1;
                    }
                }
                sum += count * (count - 1) / 2;
            }
            return sum;
        }
    }
}
