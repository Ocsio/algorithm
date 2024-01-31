package cn.ocsio.leetcode.greedy.c05;

// https://leetcode.cn/problems/jump-game-ii/
public class E0045_jump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        E0045_jump e = new E0045_jump();
        int ans = e.jump(nums);
        System.out.println(ans);
    }

    public int jump(int[] nums) {
        int ans = 0;
        int start = 0, end = 1;
        while (end < nums.length) {
            int max = 0;
            for (int i = start; i < end; i++) {
                max = Math.max(max, nums[i] + 1);
            }
            start = end;
            end = max + 1;
            ans++;
        }
        return ans;
    }

    public int jumpDP(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 2; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[nums.length - 1];
    }
}
