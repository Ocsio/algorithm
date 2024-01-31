package cn.ocsio.leetcode.greedy.c03;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
public class E0122_maxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        E0122_maxProfit e = new E0122_maxProfit();
        int ans = e.maxProfit(prices);
        System.out.println(ans);
    }

    /*
        绘制以天数为 x，股票价格为 y 的坐标系
        所有单增线段的股票差之和就是最终盈利
        要赚钱，一定要低价买入，高价卖出
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }
}
