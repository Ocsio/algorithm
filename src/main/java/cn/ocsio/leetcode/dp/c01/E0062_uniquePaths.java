package cn.ocsio.leetcode.dp.c01;

public class E0062_uniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        E0062_uniquePaths e = new E0062_uniquePaths();
        int ans = e.uniquePaths(m, n);
        System.out.println(ans);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化第 0 行
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 初始化第 0 列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
