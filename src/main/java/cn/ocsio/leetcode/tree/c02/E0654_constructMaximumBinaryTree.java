package cn.ocsio.leetcode.tree.c02;

// https://leetcode.cn/problems/maximum-binary-tree/
public class E0654_constructMaximumBinaryTree {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        E0654_constructMaximumBinaryTree e = new E0654_constructMaximumBinaryTree();
        TreeNode ans = e.constructMaximumBinaryTree(nums);
        System.out.println(ans);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int maxIndex = getMaxIndex(nums, begin, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        // 递归建树
        root.left = build(nums, begin, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, end);
        return root;
    }

    public int getMaxIndex(int[] nums, int begin, int end) {
        int maxIndex = begin;
        for (int i = begin; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
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
