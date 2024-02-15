package cn.ocsio.leetcode.dp.c02.a01;

// https://leetcode.cn/problems/ones-and-zeroes/
public class E0474_findMaxForm {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        E0474_findMaxForm e = new E0474_findMaxForm();
        int ans = e.findMaxForm(strs, m, n);
        System.out.println(ans);
    }

    // 二维费用背包
    public int findMaxForm(String[] strs, int m, int n) {
        int[] w = new int[strs.length];
        int[] v = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    w[i]++;
                } else {
                    v[i]++;
                }
            }
        }
        // 物品序号 + 一维限制 + 一维限制
        // int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        // for (int i = 1; i < strs.length + 1; i++) {
        //     for (int j = 0; j < m + 1; j++) {
        //         for (int k = 0; k < n + 1; k++) {
        //             dp[i][j][k] = (j >= w[i - 1] && k >= v[i - 1]) ?
        //                     Math.max(dp[i - 1][j][k], dp[i - 1][j - w[i - 1]][k - v[i - 1]] + 1) : dp[i - 1][j][k];
        //         }
        //     }
        // }
        // return dp[strs.length][m][n];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < strs.length + 1; i++) {
            for (int j = m; j >= w[i - 1]; j--) {
                for (int k = n; k >= v[i - 1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - w[i - 1]][k - v[i - 1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
