package cn.ocsio.leetcode.dp.c05.a01;

// https://leetcode.cn/problems/uncrossed-lines/
public class E1035_maxUncrossedLines {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 2};
        int[] nums2 = {1, 2, 4};
        E1035_maxUncrossedLines e = new E1035_maxUncrossedLines();
        int ans = e.maxUncrossedLines(nums1, nums2);
        System.out.println(ans);
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // dp[i][0] = dp[0][j] = 0
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (nums1[i - 1] == nums2[j - 1]) ? dp[i - 1][j - 1] + 1 :
                        Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
