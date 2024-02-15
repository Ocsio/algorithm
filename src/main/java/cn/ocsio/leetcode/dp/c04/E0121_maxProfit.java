package cn.ocsio.leetcode.dp.c04;

import cn.ocsio.utils.Print;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
public class E0121_maxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        E0121_maxProfit e = new E0121_maxProfit();
        int ans = e.maxProfitDP(prices);
        System.out.println(ans);
    }

    // 贪心：往左取最小值，往右取最大值
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            low = Math.min(low, price);
            ans = Math.max(ans, price - low);
        }
        return ans;
    }

    public int maxProfitDP(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // dp[i][0] 表示第 i 天持有股票的最大收益
        // dp[i][1] 表示第 i 天不持有股票的最大收益
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        Print.print(dp);
        return dp[prices.length - 1][1];
    }
}
