package D496;

import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author luliuquan
 * @date 2021/10/26 17:40
 */
public class D496 {
    public static void main(String[] args) {
        //[4,1,2]
        //[1,3,4,2]
        final int[] nums1 = JSONUtil.parseArray("[4,1,2]").stream().mapToInt(e -> Integer.parseInt(e.toString())).toArray();
        final int[] nums2 = JSONUtil.parseArray("[1,3,4,2]").stream().mapToInt(e -> Integer.parseInt(e.toString())).toArray();
        System.out.println(JSONUtil.parseArray(new Solution().nextGreaterElement(nums1, nums2)));

    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> index = new HashMap<>();
        for (int j : nums2) {
            while (!s.empty() && s.peek() < j) {
                index.put(s.pop(), j);
            }
            s.push(j);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = index.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}