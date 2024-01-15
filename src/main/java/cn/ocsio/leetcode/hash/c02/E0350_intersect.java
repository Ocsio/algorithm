package cn.ocsio.leetcode.hash.c02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.cn/problems/intersection-of-two-arrays-ii/
public class E0350_intersect {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        E0350_intersect e = new E0350_intersect();
        int[] ans = e.intersect(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                ans.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
