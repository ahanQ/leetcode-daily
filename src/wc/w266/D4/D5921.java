package wc.w266.D4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luliuquan
 * @date 2021/11/7 10:46
 */
public class D5921 {
    public static void main(String[] args) {
        System.out.println(new Solution().maximalPathQuality(new int[]{0, 32, 10, 43}, new int[][]{{0, 1, 10}, {1, 2, 15}, {0, 3, 10}}, 49));
        System.out.println(new Solution().maximalPathQuality(new int[]{5, 10, 15, 20}, new int[][]{{0, 1, 10}, {1, 2, 10}, {0, 3, 10}}, 30));
        System.out.println(new Solution().maximalPathQuality(new int[]{1, 2, 3, 4}, new int[][]{{0, 1, 10}, {1, 2, 11}, {2, 3, 12}, {1, 3, 13}}, 50));
        System.out.println(new Solution().maximalPathQuality(new int[]{0, 1, 2}, new int[][]{{1, 2, 10}}, 10));
    }
}

class Solution {
    List<List<int[]>> adj;
    boolean[] flag;
    int[] values;
    int res = 0;
    int maxTime;
    int n;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.values = values;
        this.maxTime = maxTime;
        adj = new LinkedList<>();
        n = values.length;
        flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            int c = e[2];
            adj.get(a).add(new int[]{b, c});
            adj.get(b).add(new int[]{a, c});
        }
        flag[0] = true;
        dfs(0, values[0], 0);
        return res;
    }

    public void dfs(int node, int curr, int time) {
        if (time > maxTime) {
            return;
        }
        if (node == 0) {
            res = Math.max(res, curr);
        }
        for (int[] tmp : adj.get(node)) {
            if (flag[tmp[0]]) {
                dfs(tmp[0], curr, time + tmp[1]);
            } else {
                flag[tmp[0]] = true;
                dfs(tmp[0], curr + values[tmp[0]], time + tmp[1]);
                flag[tmp[0]] = false;
            }

        }
    }
}