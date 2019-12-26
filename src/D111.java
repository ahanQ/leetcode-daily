import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 二叉树的最小深度
 *
 * @author luliuquan
 * @date 2019年12月26日
 */
public class D111 {
    public static void main(String[] args) {
        Path path = Paths.get(".\\in\\" + D111.class.getSimpleName());
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] split = line.split(",");
                new SolutionWarp().minDepth(TreeNode.arrayToTree(0, split));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SolutionWarp extends Solution {
        @Override
        public int minDepth(TreeNode root) {
            System.out.println(root);
            long start = System.currentTimeMillis();
            int result = super.minDepth(root);
            long end = System.currentTimeMillis();
            System.out.printf("time: %s result:%s\n", (end - start), result);
            return result;
        }
    }

    /**
     *
     */
    static
    class Solution {
        public int minDepth(TreeNode root) {
            return minDepth2(root);
        }

        private int minDepth2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null || root.right == null) {
                return Math.max(minDepth2(root.left), minDepth2(root.right)) + 1;
            }
            return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
        }
    }

}