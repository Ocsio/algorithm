package cn.ocsio.leetcode.dp.c02.a02;

import java.util.Arrays;

// https://leetcode.cn/problems/coin-change-ii/
public class E0518_change {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        E0518_change e = new E0518_change();
        int ans = e.change(amount, coins);
        System.out.println(ans);
    }

    public int change(int amount, int[] coins) {
        // int[][] dp = new int[coins.length + 1][amount + 1];
        // for (int i = 0; i < dp.length; i++) {
        //     dp[i][0] = 1;
        // }
        // for (int i = 1; i < dp.length; i++) {
        //     for (int j = 1; j < dp[0].length; j++) {
        //         for (int k = 0; k * coins[i - 1] <= j; k++) {
        //             dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
        //         }
        //     }
        // }
        // return dp[coins.length][amount];
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] += dp[j - coins[i - 1]];
            }
        }
        return dp[amount];
    }
}
