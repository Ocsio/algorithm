package cn.ocsio.leetcode.tree.c03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/binary-tree-paths/
public class E0257_binaryTreePaths {
    List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        E0257_binaryTreePaths e = new E0257_binaryTreePaths();
        List<String> ans = e.binaryTreePaths(root);
        System.out.println(ans);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return ans;
        }
        dfs(new LinkedList<>(), root);
        return ans;
    }

    public void dfs(List<TreeNode> path, TreeNode root) {
        if (root == null) {
            return;
        }
        path.add(root);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (TreeNode treeNode : path) {
                sb.append(treeNode.val).append("->");
            }
            ans.add(sb.substring(0, sb.length() - 2));
            path.remove(root);
            return;
        }
        dfs(path, root.left);
        dfs(path, root.right);
        path.remove(root);
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
