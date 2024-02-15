package cn.ocsio.leetcode.dp.c01;

import static cn.ocsio.utils.Print.print;

// https://leetcode.cn/problems/unique-paths-ii/
public class E0063_uniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0},
        };
        E0063_uniquePathsWithObstacles e = new E0063_uniquePathsWithObstacles();
        int ans = e.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        print(dp);
        return dp[m - 1][n - 1];
    }
}
