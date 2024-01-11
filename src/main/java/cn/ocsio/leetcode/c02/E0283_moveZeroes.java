package cn.ocsio.leetcode.c02;

import java.util.Arrays;

// https://leetcode.cn/problems/move-zeroes/
public class E0283_moveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        E0283_moveZeroes e = new E0283_moveZeroes();
        e.moveZeroes(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        // 将 slow 后的所有值置为 0
        while (slow != nums.length) {
            nums[slow++] = 0;
        }
    }
}
