package cn.ocsio.leetcode.dp.c05.a02;

import java.util.Arrays;

// https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
public class E0674_findLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        E0674_findLengthOfLCIS e = new E0674_findLengthOfLCIS();
        int ans = e.findLengthOfLCIS(nums);
        System.out.println(ans);
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) {
            return 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
