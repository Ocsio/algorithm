package cn.ocsio.leetcode.c02;

import java.util.Arrays;

// https://leetcode.cn/problems/squares-of-a-sorted-array/
public class E0977_sortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        E0977_sortedSquares e = new E0977_sortedSquares();
        int[] ans = e.sortedSquares(nums);
        System.out.println("ans = " + Arrays.toString(ans));
    }

    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length - 1;
        // 操作结果数组的索引
        int index = nums.length - 1;
        while (left <= right) {
            int val1 = nums[left] * nums[left];
            int val2 = nums[right] * nums[right];
            if (val1 >= val2) {
                left++;
                ans[index--] = val1;
            } else {
                right--;
                ans[index--] = val2;
            }
        }
        return ans;
    }
}
