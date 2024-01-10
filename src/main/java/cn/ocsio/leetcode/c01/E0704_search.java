package cn.ocsio.leetcode.c01;

// https://leetcode.cn/problems/binary-search/description/
public class E0704_search {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        E0704_search e = new E0704_search();
        int target = 9;
        int ans = e.search(nums, target);
        System.out.println(ans);
    }

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        // 没找到返回 -1
        return -1;
    }
}
