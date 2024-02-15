package cn.ocsio.leetcode.dp.c01;

// https://leetcode.cn/problems/unique-binary-search-trees/
public class E0096_numTrees {
    public static void main(String[] args) {
        int n = 3;
        E0096_numTrees e = new E0096_numTrees();
        int ans = e.numTrees(n);
        System.out.println(ans);
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            // 计算第 i 个 catalan 数
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
