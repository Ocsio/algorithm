package cn.ocsio.leetcode.backtracking.c06;

import java.util.*;

// https://leetcode.cn/problems/non-decreasing-subsequences/
public class E0491_findSubsequences {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        E0491_findSubsequences e = new E0491_findSubsequences();
        List<List<Integer>> ans = e.findSubsequences(nums);
        System.out.println(ans);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return ans;
    }

    public void backtracking(int[] nums, int pos) {
        if (pos == nums.length) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = pos; i < nums.length; i++) {
            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i] || set.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            if (path.size() >= 2) {
                ans.add(new ArrayList<>(path));
            }
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
