package cn.ocsio.leetcode.dp.c02.a01;

import java.util.Arrays;

// https://leetcode.cn/problems/target-sum/
public class E0494_findTargetSumWays {
    int ans = 0;

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        E0494_findTargetSumWays e = new E0494_findTargetSumWays();
        int target = 3;
        int ans = e.findTargetSumWays(nums, target);
        System.out.println(ans);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        // 若 (sum + target) 为奇数或者 target 大于 sum 则没有方案
        target = Math.abs(target);
        if (((sum + target) & 1) == 1 || target > sum) {
            return 0;
        }
        target = (sum + target) / 2;
        // int[] dp = new int[target + 1];
        // dp[0] = 1;
        // for (int i = 1; i <= nums.length; i++) {
        //     for (int j = target; j >= nums[i - 1]; j--) {
        //         dp[j] = dp[j] + dp[j - nums[i - 1]];
        //     }
        // }
        // return dp[target];
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                dp[i][j] = (j >= nums[i - 1]) ? dp[i - 1][j] + dp[i - 1][j - nums[i - 1]] :
                        dp[i - 1][j];
            }
        }
        // Print.print(dp);
        return dp[nums.length][target];
    }

    public int findTargetSumWaysBacktracking(int[] nums, int target) {
        backtracking(nums, target, 0, Arrays.stream(nums).sum());
        return ans;
    }

    public void backtracking(int[] nums, int target, int pos, int sum) {
        if (sum == target) {
            ans++;
        }
        if (pos == nums.length) {
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            // 在第 i 个位置添加减号
            sum -= 2 * nums[i];
            backtracking(nums, target, i + 1, sum);
            // 在第 i 个位置去掉减号
            sum += 2 * nums[i];
        }
    }
}
