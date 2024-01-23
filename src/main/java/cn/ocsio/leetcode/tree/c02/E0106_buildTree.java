package cn.ocsio.leetcode.tree.c02;

import java.util.HashMap;

// https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class E0106_buildTree {
    HashMap<Integer, Integer> map;

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        E0106_buildTree e = new E0106_buildTree();
        TreeNode ans = e.buildTree(inorder, postorder);
        System.out.println(ans);
    }

    /*
        以后序数组的最后一个元素为切割点，先切中序数组，根据中序数组，反过来再切后序数组
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return doBuild(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode doBuild(int[] inorder, int[] postorder, int postLe, int postRi, int inLe, int inRi) {
        if (postLe > postRi) {
            return null;
        }
        int rootVal = postorder[postRi];
        // 构建根节点
        TreeNode root = new TreeNode(rootVal);
        // 从 map 中查找 rootVal 在 inOrder 中的索引
        int index = map.get(rootVal);
        int leftSize = index - inLe;
        // 递归建树
        root.left = doBuild(inorder, postorder,
                postLe, postLe + leftSize - 1, inLe, inLe + index - 1);
        root.right = doBuild(inorder, postorder,
                postLe + leftSize, postRi - 1, index + 1, inRi);
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
