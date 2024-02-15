package cn.ocsio.leetcode.dp.c05.a04;

// https://leetcode.cn/problems/longest-palindromic-subsequence/
public class E0516_longestPalindromeSubseq {
    public static void main(String[] args) {
        String s = "bbbab";
        E0516_longestPalindromeSubseq e = new E0516_longestPalindromeSubseq();
        int ans = e.longestPalindromeSubseq(s);
        System.out.println(ans);
    }

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] + 2
                        : Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return dp[0][s.length() - 1];
    }
}
