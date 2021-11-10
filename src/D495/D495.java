package D495;

/**
 * @author luliuquan
 * @date 2021/11/10 9:33
 */
public class D495 {
    public static void main(String[] args) {
        System.out.println(new Solution().findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(new Solution().findPoisonedDuration(new int[]{1, 2}, 2));
    }
}

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 1) {
            return duration;
        }
        int sum = 0;
        int start = timeSeries[0];
        int last = timeSeries[0];

        for (int i = 1; i < timeSeries.length; i++) {
            int time = timeSeries[i];
            if (time - last <= duration) {
                last = time;
            } else {
                sum += last - start + duration;
                start = time;
                last = time;
            }
            if (i == timeSeries.length - 1) {
                sum += last - start + duration;
            }
        }
        return sum;
    }
}
