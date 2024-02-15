package cn.ocsio.leetcode.dp.c01;

// https://leetcode.cn/problems/fibonacci-number/
public class E0509_fib {
    public static void main(String[] args) {
        int n = 10;
        E0509_fib e = new E0509_fib();
        int ans = e.fib(n);
        System.out.println(ans);
    }

    public int fib(int n) {
        if (n < 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
