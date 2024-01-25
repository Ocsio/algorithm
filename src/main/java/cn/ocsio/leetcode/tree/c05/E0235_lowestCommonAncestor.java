package cn.ocsio.leetcode.tree.c05;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class E0235_lowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        root.left = p;
        TreeNode q = new TreeNode(1);
        root.right = q;
        p.left = new TreeNode(6);
        p.right = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        q.left = new TreeNode(0);
        q.right = new TreeNode(8);
        E0235_lowestCommonAncestor e = new E0235_lowestCommonAncestor();
        TreeNode ans = e.lowestCommonAncestor(root, p, q);
        System.out.println(ans);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
