package cn.ocsio.leetcode.greedy.c01;

import java.util.Arrays;

// https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
public class E1005_largestSumAfterKNegations {
    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        E1005_largestSumAfterKNegations e = new E1005_largestSumAfterKNegations();
        int k = 1;
        int ans = e.largestSumAfterKNegations(nums, k);
        System.out.println(ans);
    }

    /*
        - 将数组按照绝对值大小升序排序。
        - 从前向后遍历，若遇到负数则将其变为正数，同时 k-1，直到遍历完或者 k=0。
        - 若遍历完后 k 仍然大于 0，则反复转变数值最小的元素，直到 k=0。
        - 最后返回数组的和即可。
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = Arrays.stream(nums).boxed().
                sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k > 0 && (k & 1) == 1) {
            nums[nums.length - 1] = -nums[nums.length - 1];
        }
        return Arrays.stream(nums).sum();
    }
}
