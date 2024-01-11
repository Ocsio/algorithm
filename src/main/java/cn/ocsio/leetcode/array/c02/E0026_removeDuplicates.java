package cn.ocsio.leetcode.array.c02;

import java.util.Arrays;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
public class E0026_removeDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1};
        E0026_removeDuplicates e = new E0026_removeDuplicates();
        int ans = e.removeDuplicates(nums);
        System.out.println(ans);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
