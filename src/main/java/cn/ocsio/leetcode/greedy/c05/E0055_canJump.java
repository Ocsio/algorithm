package cn.ocsio.leetcode.greedy.c05;

// https://leetcode.cn/problems/jump-game/description/
public class E0055_canJump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        E0055_canJump e = new E0055_canJump();
        boolean ans = e.canJump(nums);
        System.out.println(ans);
    }

    public boolean canJump(int[] nums) {
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > right) {
                return false;
            }
            right = Math.max(nums[i] + i, right);
        }
        return false;
    }
}
