package cn.ocsio.leetcode.tree.c04;

import java.util.*;

// https://leetcode.cn/problems/find-mode-in-binary-search-tree/
public class E0501_findMode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));
        E0501_findMode e = new E0501_findMode();
        int[] ans = e.findMode(root);
        System.out.println(Arrays.toString(ans));
    }

    public int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int maxCount = 0, count = 0;
        ans.add(root.val);
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                // pre 为 null 表示最小的节点，count 为 1
                if (pre == null) {
                    count = 1;
                } else if (pre.val == pop.val) {
                    // 与前一个节点值相同则 count++
                    count++;
                } else {
                    // 与前一个节点值不同则 count = 1
                    count = 1;
                }
                // 若此时 count == maxCount 表示两个节点的频率一致，加入 ans
                if (count == maxCount) {
                    ans.add(pop.val);
                }
                // 若此时 count > maxCount 则更新 maxCount 并将该节点加入 ans
                if (count > maxCount) {
                    maxCount = count;
                    ans.clear();
                    ans.add(pop.val);
                }
                pre = pop;
                cur = pop.right;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
