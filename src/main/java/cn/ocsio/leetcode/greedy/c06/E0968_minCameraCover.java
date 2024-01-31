package cn.ocsio.leetcode.greedy.c06;

// https://leetcode.cn/problems/binary-tree-cameras/
public class E0968_minCameraCover {
    int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0, new TreeNode(0), new TreeNode(0));
        E0968_minCameraCover e = new E0968_minCameraCover();
        int ans = e.minCameraCover(root);
        System.out.println(ans);
    }

    public int minCameraCover(TreeNode root) {
        if (minCame(root) == 0) {
            ans++;
        }
        return ans;
    }

    /**
     * 节点的状态值：
     * 0——无覆盖
     * 1——有摄像头
     * 2——有覆盖
     */
    public int minCame(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = minCame(root.left);
        int right = minCame(root.right);

        if (left == 2 && right == 2) {
            return 0;
        } else if (left == 0 || right == 0) {
            ans++;
            return 1;
        } else {
            return 2;
        }
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
