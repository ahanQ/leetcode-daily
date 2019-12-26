import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 二叉树
 *
 * @author luliuquan
 * @date 2019/12/26 9:35
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode arrayToTree(int node, String[] array) {
        if (node >= array.length) {
            return null;
        }
        String val = array[node];
        if (Objects.equals(val, "null") || Objects.equals(val, "")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(val));
        treeNode.left = arrayToTree(2 * node + 1, array);
        treeNode.right = arrayToTree(2 * node + 2, array);
        return treeNode;
    }

    @Override
    public String toString() {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        queue.add(this);
        StringBuilder sb2 = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode == null) {
                sb2.append("null").append(",");
            } else {
                sb.append(sb2.toString());
                sb2.setLength(0);
                sb.append(treeNode.val).append(",");
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}
