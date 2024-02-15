package cn.ocsio.leetcode.dp.c02.a02;

// https://leetcode.cn/problems/coin-change/
public class E0322_coinChange {
    int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] coins = {1, 2147483647};
        int amount = 2;
        E0322_coinChange e = new E0322_coinChange();
        int ans = e.coinChange(coins, amount);
        System.out.println(ans);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = coins[i - 1]; j < amount + 1; j++) {
                if (dp[j - coins[i - 1]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - coins[i - 1]] + 1, dp[j]);
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }

    public int coinChangeBacktracking(int[] coins, int amount) {
        backtracking(coins, amount, 0, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void backtracking(int[] coins, int amount, int count, long now) {
        if (now == amount) {
            ans = Math.min(ans, count);
            return;
        }
        if (now > amount) {
            return;
        }
        for (int coin : coins) {
            backtracking(coins, amount, count + 1, now + coin);
        }
    }
}
