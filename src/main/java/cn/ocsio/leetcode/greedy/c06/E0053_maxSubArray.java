package cn.ocsio.leetcode.greedy.c06;

// https://leetcode.cn/problems/maximum-subarray/
public class E0053_maxSubArray {
    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        E0053_maxSubArray e = new E0053_maxSubArray();
        int ans = e.maxSubArray(nums);
        System.out.println(ans);
    }

    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            count += num;
            ans = Math.max(ans, count);
            count = Math.max(count, 0);
        }
        return ans;
    }

    public int maxSubArrayDP(int[] nums) {
        int ans = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = (dp[i - 1] > 0) ? nums[i] + dp[i - 1] : nums[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
