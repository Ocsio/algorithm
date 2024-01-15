package cn.ocsio.leetcode.hash.c04;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.cn/problems/two-sum/
public class E0001_twoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        E0001_twoSum e = new E0001_twoSum();
        int target = 9;
        int[] ans = e.twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
