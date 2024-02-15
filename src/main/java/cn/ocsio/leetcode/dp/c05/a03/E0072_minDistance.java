package cn.ocsio.leetcode.dp.c05.a03;

import cn.ocsio.utils.Print;

// https://leetcode.cn/problems/edit-distance/
public class E0072_minDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        E0072_minDistance e = new E0072_minDistance();
        int ans = e.minDistance(word1, word2);
        System.out.println(ans);
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? dp[i - 1][j - 1] :
                        Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
