package cn.ocsio.leetcode.dp.c05.a03;

// https://leetcode.cn/problems/is-subsequence/
public class E0392_isSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        E0392_isSubsequence e = new E0392_isSubsequence();
        boolean ans = e.isSubsequence(s, t);
        System.out.println(ans);
    }

    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (s.charAt(i - 1) == t.charAt(j - 1)) ? dp[i - 1][j - 1] + 1
                        : dp[i][j - 1];
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}
