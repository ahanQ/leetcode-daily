import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 尽量减少恶意软件的传播
 *
 * @author luliuquan
 * @date 2019年12月30日
 */
public class D924 {
    public static void main(String[] args) {
        Path path = Paths.get(".\\in\\" + D924.class.getSimpleName());
        try {
            List<String> lines = Files.readAllLines(path);
            int size = lines.size();
            for (int i = 0; i < size / 2; i += 2) {
                String s1 = lines.get(i);
                String s2 = lines.get(i + 1);
                int[][] graph = toArray(s1, 2);
                int[] initial = toArray(s2);
                new SolutionWarp().minMalwareSpread(graph, initial);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][] toArray(String s, int dimension) {
        s = s.replaceFirst("\\[\\[", "").replace("]]", "");
        String[] split = s.split("],\\[");
        int al = split.length;
        int[][] result = new int[al][];
        for (int j = 0; j < split.length; j++) {
            result[j] = toArray("[" + split[j] + "]");
        }
        return result;
    }

    private static int[] toArray(String s) {
        s = s.replaceFirst("\\[", "").replaceFirst("(?s)](?!.*?])", "");
        String[] split = s.split(",");
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

    static class SolutionWarp extends Solution {
        @Override
        public int minMalwareSpread(int[][] graph, int[] initial) {
            long start = System.currentTimeMillis();
            int result = super.minMalwareSpread(graph, initial);
            long end = System.currentTimeMillis();
            System.out.printf("time: %s result: %s\n", (end - start), result);
            return result;
        }
    }

    /**
     * 做不出来，照搬答案，只理解。
     */
    static
    class Solution {
        public int minMalwareSpread(int[][] graph, int[] initial) {
            // 1. Color each component.
            // colors[node] = the color of this node.

            int n = graph.length;
            int[] colors = new int[n];
            Arrays.fill(colors, -1);
            int c = 0;

            for (int node = 0; node < n; ++node) {
                if (colors[node] == -1) {
                    dfs(graph, colors, node, c++);
                }
            }

            // 2. Size of each color.
            int[] size = new int[c];
            for (int color : colors) {
                size[color]++;
            }

            // 3. Find unique colors.
            int[] colorCount = new int[c];
            for (int node : initial) {
                colorCount[colors[node]]++;
            }

            // 4. Answer
            int ans = Integer.MAX_VALUE;
            for (int node : initial) {
                int color = colors[node];
                if (colorCount[color] == 1) {
                    if (ans == Integer.MAX_VALUE) {
                        ans = node;
                    } else if (size[color] > size[colors[ans]]) {
                        ans = node;
                    } else if (size[color] == size[colors[ans]] && node < ans) {
                        ans = node;
                    }
                }
            }

            if (ans == Integer.MAX_VALUE) {
                for (int node : initial) {
                    ans = Math.min(ans, node);
                }
            }

            return ans;
        }

        public void dfs(int[][] graph, int[] colors, int node, int color) {
            colors[node] = color;
            for (int nei = 0; nei < graph.length; ++nei) {
                if (graph[node][nei] == 1 && colors[nei] == -1) {
                    dfs(graph, colors, nei, color);
                }
            }
        }
    }
}