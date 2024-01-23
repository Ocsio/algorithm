package cn.ocsio.leetcode.tree.c02;

// https://leetcode.cn/problems/merge-two-binary-trees/
public class E0617_mergeTrees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(3,
                new TreeNode(5), null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null,
                new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        E0617_mergeTrees e = new E0617_mergeTrees();
        TreeNode ans = e.mergeTrees(root1, root2);
        System.out.println(ans);
    }

    /*
        将 root2 累加到 root1 上
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    public TreeNode dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        node1.val += node2.val;
        node1.left = dfs(node1.left, node2.left);
        node1.right = dfs(node1.right, node2.right);
        return node1;
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
