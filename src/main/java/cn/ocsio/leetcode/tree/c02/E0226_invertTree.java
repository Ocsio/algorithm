package cn.ocsio.leetcode.tree.c02;

// https://leetcode.cn/problems/invert-binary-tree/
public class E0226_invertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2,
                new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        E0226_invertTree e = new E0226_invertTree();
        TreeNode ans = e.invertTree(root);
        System.out.println(ans);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);
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
