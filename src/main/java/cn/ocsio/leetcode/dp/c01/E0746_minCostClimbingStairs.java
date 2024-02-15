package cn.ocsio.leetcode.dp.c01;

import java.util.Arrays;

// https://leetcode.cn/problems/min-cost-climbing-stairs/
public class E0746_minCostClimbingStairs {
    public static void main(String[] args) {
        E0746_minCostClimbingStairs e = new E0746_minCostClimbingStairs();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int ans = e.minCostClimbingStairs(cost);
        System.out.println(ans);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        System.out.println(Arrays.toString(dp));
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
