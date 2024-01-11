package cn.ocsio.leetcode.c02;

import java.util.Arrays;

// https://leetcode.cn/problems/remove-element/description/
public class E0027_removeElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 3, 0, 4, 2};
        int val = 2;
        E0027_removeElement e = new E0027_removeElement();
        int ans = e.removeElement(nums, val);
        System.out.println(ans);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
