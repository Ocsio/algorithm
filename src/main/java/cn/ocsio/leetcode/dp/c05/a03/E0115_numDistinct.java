package cn.ocsio.leetcode.dp.c05.a03;

import cn.ocsio.utils.Print;

// https://leetcode.cn/problems/distinct-subsequences/
public class E0115_numDistinct {
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        E0115_numDistinct e = new E0115_numDistinct();
        int ans = e.numDistinct(s, t);
        System.out.println(ans);
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (s.charAt(i - 1) == t.charAt(j - 1)) ? dp[i - 1][j - 1] + dp[i - 1][j] :
                        dp[i - 1][j];
            }
        }
        return dp[s.length()][t.length()];
    }
}
