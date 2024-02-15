package cn.ocsio.leetcode.dp.c03;

// https://leetcode.cn/problems/house-robber/
public class E0198_rob {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        E0198_rob e = new E0198_rob();
        int ans = e.rob(nums);
        System.out.println(ans);
    }

    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
