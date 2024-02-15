package cn.ocsio.leetcode.dp.c05.a04;

// https://leetcode.cn/problems/palindromic-substrings/
public class E0647_countSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        E0647_countSubstrings e = new E0647_countSubstrings();
        int ans = e.countSubstrings(s);
        System.out.println(ans);
    }

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = s.length();
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < dp[0].length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (Math.abs(i - j) <= 1) {
                        ans++;
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            ans++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
