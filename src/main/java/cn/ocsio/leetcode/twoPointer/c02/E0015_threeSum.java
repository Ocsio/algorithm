package cn.ocsio.leetcode.twoPointer.c02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/3sum/
public class E0015_threeSum {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 0, 2, 2};
        E0015_threeSum e = new E0015_threeSum();
        List<List<Integer>> ans = e.threeSum(nums);
        System.out.println(ans);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 排序后的数组如果第一个元素 > 0 则找不到符合条件的三元组
        if (nums[0] > 0) {
            return ans;
        }
        int le, ri;
        for (int i = 0; i < nums.length - 1; i++) {
            // 对元素 a 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            le = i + 1;
            ri = nums.length - 1;
            while (le < ri) {
                int sum = nums[le] + nums[ri] + nums[i];
                if (sum < 0) {
                    le++;
                } else if (sum > 0) {
                    ri--;
                } else {
                    List<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[le]);
                    li.add(nums[ri]);
                    ans.add(li);
                    // le 右移，ri 左移去掉重复元素
                    while (ri > le && nums[ri] == nums[ri - 1]) {
                        ri--;
                    }
                    while (ri > le && nums[le] == nums[le + 1]) {
                        le++;
                    }
                    ri--;
                    le++;
                }
            }
        }
        return ans;
    }
}
