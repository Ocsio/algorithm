package cn.ocsio.leetcode.tree.c04;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.cn/problems/convert-bst-to-greater-tree/
public class E0538_convertBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3)));
        root.right = new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8)));
        E0538_convertBST e = new E0538_convertBST();
        TreeNode ans = e.convertBST(root);
        System.out.println(ans);
    }

    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.right;
            } else {
                TreeNode pop = stack.pop();
                if (pre != null) {
                    pop.val += pre.val;
                }
                pre = pop;
                cur = pop.left;
            }
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
