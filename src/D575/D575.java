package D575;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 分糖果
 *
 * @author luliuquan
 * @date 2021/11/1 10:06
 */
public class D575 {
    public static void main(String[] args) {
        System.out.println(new Solution().distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(new Solution().distributeCandies(new int[]{1, 1, 2, 3}));
    }

}

class Solution {
    public int distributeCandies(int[] candyType) {
        final int length = candyType.length;
        Map<Integer, Integer> types = new LinkedHashMap<>();
        for (int j : candyType) {
            types.put(j, types.getOrDefault(j, 0) + 1);

        }
        return Math.min(types.size(), length / 2);
    }
}