package cn.ocsio.leetcode.dp.c03;

// https://leetcode.cn/problems/house-robber-ii/
public class E0213_rob {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        E0213_rob e = new E0213_rob();
        int ans = e.rob(nums);
        System.out.println(ans);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int ans1 = helper(nums, 0, nums.length - 2);
        int ans2 = helper(nums, 1, nums.length - 1);
        return Math.max(ans1, ans2);
    }

    public int helper(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + start]);
        }
        return dp[dp.length - 1];
    }
}
