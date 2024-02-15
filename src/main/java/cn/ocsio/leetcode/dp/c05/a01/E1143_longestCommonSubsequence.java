package cn.ocsio.leetcode.dp.c05.a01;

import cn.ocsio.utils.Print;

// https://leetcode.cn/problems/longest-common-subsequence/
public class E1143_longestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        E1143_longestCommonSubsequence e = new E1143_longestCommonSubsequence();
        int ans = e.longestCommonSubsequence(text1, text2);
        System.out.println(ans);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (text1.charAt(i - 1) == text2.charAt(j - 1)) ? dp[i - 1][j - 1] + 1 :
                        Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
