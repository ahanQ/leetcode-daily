package D563;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luliuquan
 * @date 2021/10/26 13:28
 */
public class D563 {
    public static void main(String[] args) {
        System.out.println(new Solution().findTilt(tree("[]")));
        System.out.println(new Solution().findTilt(tree("[1,2,3]")));
        System.out.println(new Solution().findTilt(tree("[4,2,9,3,5,null,7]")));
        System.out.println(new Solution().findTilt(tree("[21,7,14,1,1,2,2,3,3]")));
    }

    private static TreeNode tree(String treeStr) {
        if ("[]".equals(treeStr)) {
            return null;
        }
        final String[] trees = treeStr.replaceAll("[\\[\\]]", "").split(",");

        List<TreeNode> treeList = new ArrayList<>();
        for (String tree : trees) {
            if ("null".equals(tree)) {
                treeList.add(null);
            } else {
                treeList.add(new TreeNode(Integer.parseInt(tree)));
            }
        }
        for (int i = 0; i < treeList.size(); i++) {
            final TreeNode treeNode = treeList.get(i);
            if (treeNode == null) {
                continue;
            }
            if (i * 2 + 1 < trees.length) {
                treeNode.left = treeList.get(i * 2 + 1);
            }
            if (i * 2 + 2 < treeList.size()) {
                treeNode.right = treeList.get(i * 2 + 2);
            }
        }
        if (treeList.isEmpty()) {
            return null;
        }
        return treeList.get(0);
    }
}
class Solution {

    int ans = 0;

    public int sum(TreeNode rt) {
        if (rt == null) {
            return 0;
        }
        int l = sum(rt.left);
        int r = sum(rt.right);
        ans += Math.abs(l - r);
        return rt.val + l + r;
    }

    public int findTilt(TreeNode rt) {
        sum(rt);
        return ans;
    }
}
