package cn.ocsio.leetcode.dp.c02.a02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.cn/problems/word-break/
public class E0139_wordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        Collections.addAll(wordDict, "leet", "code");
        E0139_wordBreak e = new E0139_wordBreak();
        boolean ans = e.wordBreak(s, wordDict);
        System.out.println(ans);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (!dp[j]) {
                    continue;
                }
                if (wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
