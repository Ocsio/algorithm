package cn.ocsio.leetcode.array.c03;

public class E0209_minSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        E0209_minSubArrayLen e = new E0209_minSubArrayLen();
        int ans = e.minSubArrayLen(target, nums);
        System.out.println("ans = " + ans);
    }

    public int minSubArrayLen(int target, int[] nums) {
        // 记录结果，也就是满足条件的最小的区间的元素个数
        int ans = Integer.MAX_VALUE;
        // sum 变量记录区间 [winL, winR] 的和
        int sum = 0, winL = 0;
        // winL 和 winR 表示滑动窗口的左右边界
        for (int winR = 0; winR < nums.length; winR++) {
            sum += nums[winR];
            while (sum >= target) {
                ans = Math.min(ans, winR - winL + 1);
                sum -= nums[winL++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
