package cn.ocsio.leetcode.dp.c05.a03;

import cn.ocsio.utils.Print;

// https://leetcode.cn/problems/delete-operation-for-two-strings/description/
public class E0583_minDistance {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        E0583_minDistance e = new E0583_minDistance();
        int ans = e.minDistance2(word1, word2);
        System.out.println(ans);
    }

    /*
        等价于求解 word1 和 word2 的最长公共子序列，记为 max
        那么删除的次数就是 n - max + m - max，n、m 为 word1 的长度和 word2 的长度
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? dp[i - 1][j - 1] + 1 :
                        Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int max = dp[word1.length()][word2.length()];
        return word1.length() - max + word2.length() - max;
    }

    public int minDistance2(String word1, String word2) {
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
                        Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
