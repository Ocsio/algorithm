package cn.ocsio.leetcode.tree.c06;

// https://leetcode.cn/problems/insert-into-a-binary-search-tree/
public class E0701_insertIntoBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7);
        E0701_insertIntoBST e = new E0701_insertIntoBST();
        int val = 5;
        TreeNode ans = e.insertIntoBST(root, val);
        System.out.println(ans);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode cur = root;
        // 记录 cur 的父节点
        TreeNode parent = null;
        while (cur != null) {
            parent = cur;
            if (cur.val > val) {
                cur = cur.left;
            } else if (cur.val < val) {
                cur = cur.right;
            } else {
                return root;
            }
        }
        if (parent == null) {
            root = new TreeNode(val);
        } else if (val > parent.val) {
            parent.right = new TreeNode(val);
        } else {
            parent.left = new TreeNode(val);
        }
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
