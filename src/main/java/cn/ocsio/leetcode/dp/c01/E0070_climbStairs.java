package cn.ocsio.leetcode.dp.c01;

// https://leetcode.cn/problems/climbing-stairs/
public class E0070_climbStairs {
    public static void main(String[] args) {
        int n = 3;
        E0070_climbStairs e = new E0070_climbStairs();
        int ans = e.climbStairs(n);
        System.out.println(ans);
    }

    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
