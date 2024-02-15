package cn.ocsio.leetcode.dp.c05.a02;

// https://leetcode.cn/problems/maximum-subarray/
public class E0053_maxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        E0053_maxSubArray e = new E0053_maxSubArray();
        int ans = e.maxSubArray(nums);
        System.out.println(ans);
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = (dp[i - 1] > 0) ? dp[i - 1] + nums[i] : nums[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
