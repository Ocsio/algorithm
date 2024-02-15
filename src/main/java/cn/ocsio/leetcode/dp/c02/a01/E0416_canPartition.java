package cn.ocsio.leetcode.dp.c02.a01;

// https://leetcode.cn/problems/partition-equal-subset-sum/
public class E0416_canPartition {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        E0416_canPartition e = new E0416_canPartition();
        boolean ans = e.canPartition(nums);
        System.out.println(ans);
    }

    public boolean canPartition(int[] nums) {
        // 求 sum 和 max
        int sum = 0, max = Integer.MIN_VALUE;
        int halfSum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        // 若 sum 为奇数则返回 false
        if ((sum & 1) == 1) {
            return false;
        }
        // 若 sum 的一半 < max 也返回 false
        if ((halfSum = sum / 2) < max) {
            return false;
        }
        // 背包容量为 halfSum，在 nums 中找到一些物品刚好装满背包
        int[] dp = new int[halfSum + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = dp.length - 1; j >= nums[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i - 1]] + nums[i - 1]);
            }
        }
        return dp[dp.length - 1] == halfSum;
    }

    public boolean canPartition2D(int[] nums) {
        // 求 sum 和 max
        int sum = 0, max = Integer.MIN_VALUE;
        int halfSum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        // 若 sum 为奇数则返回 false
        if ((sum & 1) == 1) {
            return false;
        }
        // 若 sum 的一半 < max 也返回 false
        if ((halfSum = sum / 2) < max) {
            return false;
        }
        // 背包容量为 halfSum，在 nums 中找到一些物品刚好装满背包
        int[][] dp = new int[nums.length + 1][halfSum + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (nums[i - 1] <= j) ?
                        Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]) : dp[i - 1][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1] == halfSum;
    }
}
