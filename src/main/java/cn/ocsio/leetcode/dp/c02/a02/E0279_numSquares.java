package cn.ocsio.leetcode.dp.c02.a02;

// https://leetcode.cn/problems/perfect-squares/
public class E0279_numSquares {
    public static void main(String[] args) {
        int n = 13;
        E0279_numSquares e = new E0279_numSquares();
        int ans = e.numSquares(n);
        System.out.println(ans);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // for (int i = 1; i < Math.sqrt(n) + 1; i++) {
        //     for (int j = i * i; j < dp.length; j++) {
        //         if (dp[(int) (j - Math.pow(i, 2))] != Integer.MAX_VALUE) {
        //             dp[j] = Math.min(dp[j], dp[(int) (j - Math.pow(i, 2))] + 1);
        //         }
        //     }
        // }
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
