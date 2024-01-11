package cn.ocsio.leetcode.array.c01;

import java.util.Arrays;

// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class E0034_searchRange {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        E0034_searchRange e = new E0034_searchRange();
        int[] ans = e.searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int i = 0, j = nums.length - 1;
        // 结果区间左、右边界
        int right = 0, left = 0;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] <= target) {
                // 即使 nums[mid] == target，i 还要继续往后找，这样做是为了找到右边界
                i = mid + 1;
                right = mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            }
        }
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] >= target) {
                // 即使 nums[mid] == target，j 还要继续往前找，这样做是为了找到左边界
                j = mid - 1;
                left = mid;
            }
        }
        // 若 nums[left] 或者 nums[right] 不等于 target 说明没有这个元素，返回 {-1, -1}
        return (nums[left] == target) ? new int[]{left, right} : new int[]{-1, -1};
    }
}
