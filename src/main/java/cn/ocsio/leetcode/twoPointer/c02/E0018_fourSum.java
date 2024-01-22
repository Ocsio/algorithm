package cn.ocsio.leetcode.twoPointer.c02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/4sum/
public class E0018_fourSum {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;
        E0018_fourSum e = new E0018_fourSum();
        List<List<Integer>> ans = e.fourSum(nums, target);
        System.out.println(ans);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > target && nums[k] >= 0) {
                break;
            }
            // 对 nums[k] 去重
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            for (int i = k + 1; i < nums.length; i++) {
                if (nums[k] + nums[i] > target && nums[k] + nums[i] >= 0) {
                    break;
                }
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int le = i + 1, ri = nums.length - 1;
                while (le < ri) {
                    // 防止溢出
                    long sum = nums[k] + nums[i] + nums[le] + nums[ri];
                    if (sum < target) {
                        le++;
                    } else if (sum > target) {
                        ri--;
                    } else {
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[le]);
                        li.add(nums[ri]);
                        li.add(nums[i]);
                        li.add(nums[k]);
                        ans.add(li);
                        // 对 le 和 ri 去重
                        while (le < ri && nums[le] == nums[le + 1]) {
                            le++;
                        }
                        while (le < ri && nums[ri] == nums[ri - 1]) {
                            ri--;
                        }
                        le++;
                        ri--;
                    }
                }
            }
        }
        return ans;
    }
}


