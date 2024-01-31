package cn.ocsio.leetcode.greedy.c02;

import cn.ocsio.utils.Print;

// https://leetcode.cn/problems/wiggle-subsequence/
public class E0376_wiggleMaxLength {
    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        E0376_wiggleMaxLength e = new E0376_wiggleMaxLength();
        int ans = e.wiggleMaxLength(nums);
        System.out.println(ans);
    }

    /*
        dp：
        - dp[i][0] 表示考虑前 i 个数，第 i 个数作为山峰的摆动序列的最长长度
        - dp[i][1] 表示考虑前 i 个数，第 i 个数作为山谷的摆动序列的最长长度
        - dp[i][0] = max(dp[i][0], dp[j][1]+1)，0 < j < i，nums[j] < nums[i]，将 nums[i] 接到某个山谷后，作为山峰
        - dp[i][1] = max(dp[i][1], dp[j][0]+1)，0 < j < i，nums[j] < nums[i]，将 nums[i] 接到某个山峰后，作为山谷
        - dp[0][0] = dp[0][1] = 1
     */
    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] > nums[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
            }
        }
        Print.print(dp);
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    /*
        统计以 nums[i] 为 y 值，i 为 x 值的坐标系中，波峰加上波谷的个数
     */
    public int wiggleMaxLengthGreedy(int[] nums) {
        int ans = 1;
        int diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (isNeg(nums[i + 1] - nums[i], diff)) {
                ans++;
                diff = nums[i + 1] - nums[i];
            }
        }
        return ans;
    }

    public boolean isNeg(int i, int j) {
        return (i > 0 && j <= 0) || (i < 0 && j >= 0);
    }
}
