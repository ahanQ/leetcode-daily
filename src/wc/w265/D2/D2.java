package wc.w265.D2;

import java.util.Arrays;

/**
 * 链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。
 * 如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个  局部极大值点 。
 * 如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个  局部极小值点 。
 * 注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。
 * 给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，其中 minDistance 是任意两个不同临界点之间的最小距离，maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。
 *
 * @author luliuquan
 * @date 2021/11/4 11:06
 */
public class D2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().nodesBetweenCriticalPoints(parse("[3,1]"))));
        System.out.println(Arrays.toString(new Solution().nodesBetweenCriticalPoints(parse("[5,3,1,2,5,1,2]"))));
        System.out.println(Arrays.toString(new Solution().nodesBetweenCriticalPoints(parse("[1,3,2,2,3,2,2,2,7]"))));
        System.out.println(Arrays.toString(new Solution().nodesBetweenCriticalPoints(parse("[2,3,3,2]"))));
    }

    private static ListNode parse(String c) {
        final ListNode head = new ListNode();
        ListNode next = head;
        final String[] split = c.substring(1, c.length() - 1).split(",");
        for (int i = 0; i < split.length; i++) {
            next.val = Integer.parseInt(split[i]);
            if (i != split.length - 1) {
                next.next = new ListNode();
                next = next.next;
            }
        }
        return head;
    }
}

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        final int[] result = {-1, -1};
        int index = 0;
        int l = head.val;
        int lIndex = -1;
        int fIndex = -1;
        int rIndex = -1;
        while ((head = head.next) != null && head.next != null) {
            index++;
            boolean isMax = l < head.val && head.next.val < head.val;
            boolean isMin = l > head.val && head.next.val > head.val;
            if (isMax || isMin) {
                if (fIndex == -1) {
                    fIndex = index;
                }
                if (lIndex != -1) {
                    if (result[0] == -1) {
                        result[0] = 100000;
                    }
                    result[0] = Math.min(result[0], index - lIndex);
                }
                rIndex = index;
                lIndex = index;
            }
            l = head.val;
        }
        if (rIndex != -1 && rIndex != fIndex) {
            result[1] = rIndex - fIndex;
        }
        return result;
    }
}
