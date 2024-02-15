package cn.ocsio.leetcode.dp.c02.a02;

// https://leetcode.cn/problems/combination-sum-iv/
public class E0377_combinationSum4 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        E0377_combinationSum4 e = new E0377_combinationSum4();
        int ans = e.combinationSum4(nums, target);
        System.out.println(ans);
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j < target + 1; j++) {
            for (int i = 1; i < nums.length + 1; i++) {
                if (j >= nums[i - 1]) {
                    dp[j] += dp[j - nums[i - 1]];
                }
            }
        }
        return dp[target];
    }
}
