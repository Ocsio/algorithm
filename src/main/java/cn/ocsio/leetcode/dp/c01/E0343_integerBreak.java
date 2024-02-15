package cn.ocsio.leetcode.dp.c01;

// https://leetcode.cn/problems/integer-break/
public class E0343_integerBreak {
    public static void main(String[] args) {
        int n = 10;
        E0343_integerBreak e = new E0343_integerBreak();
        int ans = e.integerBreak(n);
        System.out.println(ans);
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
