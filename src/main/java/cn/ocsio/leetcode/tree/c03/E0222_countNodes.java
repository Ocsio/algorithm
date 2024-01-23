package cn.ocsio.leetcode.tree.c03;

public class E0222_countNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3, new TreeNode(6), null);
        E0222_countNodes e = new E0222_countNodes();
        int ans = e.countNodes(root);
        System.out.println(ans);
    }

    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + dfs(root.left) + dfs(root.right);
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
