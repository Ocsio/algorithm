package cn.ocsio.leetcode.tree.c03;

// https://leetcode.cn/problems/subtree-of-another-tree/
public class E0572_isSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        root.right = new TreeNode(5);
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        E0572_isSubtree e = new E0572_isSubtree();
        boolean ans = e.isSubtree(root, subRoot);
        System.out.println(ans);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode cur1, TreeNode cur2) {
        if (cur1 == null) {
            return false;
        }
        return check(cur1, cur2) || dfs(cur1.left, cur2) || dfs(cur1.right, cur2);
    }

    public boolean check(TreeNode cur1, TreeNode cur2) {
        if (cur1 == null && cur2 == null) {
            return true;
        }
        if (cur1 == null || cur2 == null) {
            return false;
        }
        return cur1.val == cur2.val && check(cur1.left, cur2.left) && check(cur1.right, cur2.right);
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
