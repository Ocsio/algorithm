package cn.ocsio.leetcode.dp.c05.a01;

import java.util.Arrays;

// https://leetcode.cn/problems/longest-increasing-subsequence/
public class E0300_lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        E0300_lengthOfLIS e = new E0300_lengthOfLIS();
        int ans = e.lengthOfLIS(nums);
        System.out.println(ans);
    }

    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    ans = Math.max(dp[i], ans);
                }
            }
        }
        return ans;
    }
}
