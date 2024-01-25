package cn.ocsio.leetcode.tree.c04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.cn/problems/validate-binary-search-tree/
public class E0098_isValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2147483648);
        E0098_isValidBST e = new E0098_isValidBST();
        boolean ans = e.isValidBST(root);
        System.out.println(ans);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        long min = Long.MIN_VALUE;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                // 如果中序遍历的节点值 <= 前一个 min 值则不是二叉搜索树
                if (pop.val <= min) {
                    return false;
                }
                min = pop.val;
                cur = pop.right;
            }
        }
        return true;
    }

    public boolean isHigh(List<Integer> inorder) {
        for (int i = 0; i < inorder.size(); i++) {
            if (i + 1 < inorder.size() && inorder.get(i) >= inorder.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getInorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                ans.add(pop.val);
                cur = pop.right;
            }
        }
        return ans;
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
