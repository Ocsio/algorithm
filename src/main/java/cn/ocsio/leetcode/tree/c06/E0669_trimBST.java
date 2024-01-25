package cn.ocsio.leetcode.tree.c06;

public class E0669_trimBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        int low = 1;
        int high = 2;
        E0669_trimBST e = new E0669_trimBST();
        TreeNode ans = e.trimBST(root, low, high);
        System.out.println(ans);
    }

    /**
     * 去掉 root 这棵树上节点值不在 [low,high] 之间的节点，并返回新的头节点
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
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
