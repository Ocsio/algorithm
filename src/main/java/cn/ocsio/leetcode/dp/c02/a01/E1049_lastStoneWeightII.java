package cn.ocsio.leetcode.dp.c02.a01;

import java.util.Arrays;

// https://leetcode.cn/problems/last-stone-weight-ii/
public class E1049_lastStoneWeightII {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        E1049_lastStoneWeightII e = new E1049_lastStoneWeightII();
        int ans = e.lastStoneWeightII(stones);
        System.out.println(ans);
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int halfSum = sum / 2;
        int[] dp = new int[halfSum + 1];
        for (int i = 1; i < stones.length + 1; i++) {
            for (int j = dp.length - 1; j >= stones[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i - 1]] + stones[i - 1]);
            }
        }
        return sum - 2 * dp[halfSum];
    }
}
