package cn.ocsio.leetcode.tree.c01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.cn/problems/binary-tree-postorder-traversal/
public class E0145_postorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        E0145_postorderTraversal e = new E0145_postorderTraversal();
        List<Integer> ans = e.postorderTraversal(root);
        System.out.println(ans);
    }

    /*
        先序遍历（根左右） =》调整代码左右顺序 =》根右左 =》反转 ans 数组 =》左右根
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            ans.add(pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        reverse(ans);
        return ans;
    }

    public void reverse(List<Integer> ans) {
        int i = 0, j = ans.size() - 1;
        while (i < j) {
            swap(ans, i++, j--);
        }
    }

    public void swap(List<Integer> ans, int i, int j) {
        int temp = ans.get(i);
        ans.set(i, ans.get(j));
        ans.set(j, temp);
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
