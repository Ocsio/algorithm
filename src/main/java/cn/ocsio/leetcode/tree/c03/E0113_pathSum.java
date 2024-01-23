package cn.ocsio.leetcode.tree.c03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.cn/problems/path-sum-ii/
public class E0113_pathSum {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null);
        root.right = new TreeNode(8, new TreeNode(11), new TreeNode(4, new TreeNode(5), new TreeNode(1)));
        E0113_pathSum e = new E0113_pathSum();
        int targetSum = 22;
        List<List<Integer>> ans = e.pathSum(root, targetSum);
        System.out.println(ans);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }

    public void dfs(TreeNode cur, int targetSum) {
        if (cur == null) {
            return;
        }
        path.offerLast(cur.val);
        targetSum -= cur.val;
        if (cur.left == null && cur.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(path));
        }
        dfs(cur.left, targetSum);
        dfs(cur.right, targetSum);
        path.pollLast();
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

        @Override
        public String toString() {
            return "" + val;
        }
    }
}
