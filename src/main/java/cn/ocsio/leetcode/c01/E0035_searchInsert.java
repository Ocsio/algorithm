package cn.ocsio.leetcode.c01;

// https://leetcode.cn/problems/search-insert-position/description/
public class E0035_searchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        E0035_searchInsert e = new E0035_searchInsert();
        int ans = e.searchInsert(nums, target);
        System.out.println(ans);
    }

    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        // 记录 target 的候选位置，从 0 开始逐渐增加
        int candidate = 0;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] < target) {
                i = mid + 1;
                candidate = i;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return candidate;
    }
}
