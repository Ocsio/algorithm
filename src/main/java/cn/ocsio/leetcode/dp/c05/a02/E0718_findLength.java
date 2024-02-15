package cn.ocsio.leetcode.dp.c05.a02;

// https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
public class E0718_findLength {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        E0718_findLength e = new E0718_findLength();
        int ans = e.findLength(nums1, nums2);
        System.out.println(ans);
    }

    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
