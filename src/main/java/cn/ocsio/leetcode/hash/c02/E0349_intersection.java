package cn.ocsio.leetcode.hash.c02;

import java.util.*;

// https://leetcode.cn/problems/intersection-of-two-arrays/
public class E0349_intersection {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        E0349_intersection e = new E0349_intersection();
        int[] ans = e.intersection(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
