package cn.ocsio.leetcode.tree.c06;

// https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
public class E0108_sortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        E0108_sortedArrayToBST e = new E0108_sortedArrayToBST();
        TreeNode ans = e.sortedArrayToBST(nums);
        System.out.println(ans);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (i + j) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, i, mid - 1);
        root.right = build(nums, mid + 1, j);
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
