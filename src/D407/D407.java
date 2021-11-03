package D407;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author luliuquan
 * @date 2021/11/3 16:51
 */
public class D407 {
    public static void main(String[] args) {
        System.out.println(new Solution().trapRainWater(parse("[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]")));
        System.out.println(new Solution().trapRainWater(parse("[[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]")));
    }

    private static int[][] parse(String input) {
        List<List<Integer>> t = new ArrayList<>();
        final char[] chars = input.toCharArray();
        List<Integer> tt = new ArrayList<>();
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '[') {
                tt = new ArrayList<>();
            } else if (chars[i] == ']') {
                t.add(tt);
            } else if (chars[i] != ',') {
                tt.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }
        int[][] result = new int[t.size()][];
        for (int i = 0; i < t.size(); i++) {
            final List<Integer> n = t.get(i);
            result[i] = new int[n.size()];
            for (int j = 0; j < n.size(); j++) {
                final Integer v = n.get(j);
                result[i][j] = v;
            }
        }
        return result;
    }
}
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};
        int maxHeight = 0;

        for (int[] ints : heightMap) {
            for (int j = 0; j < n; ++j) {
                maxHeight = Math.max(maxHeight, ints[j]);
            }
        }
        int[][] water = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j){
                water[i][j] = maxHeight;
            }
        }
        Queue<int[]> qu = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (water[i][j] > heightMap[i][j]) {
                        water[i][j] = heightMap[i][j];
                        qu.offer(new int[]{i, j});
                    }
                }
            }
        }
        while (!qu.isEmpty()) {
            int[] curr = qu.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i], ny = y + dirs[i + 1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (water[x][y] < water[nx][ny] && water[nx][ny] > heightMap[nx][ny]) {
                    water[nx][ny] = Math.max(water[x][y], heightMap[nx][ny]);
                    qu.offer(new int[]{nx, ny});
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res += water[i][j] - heightMap[i][j];
            }
        }
        return res;
    }
}