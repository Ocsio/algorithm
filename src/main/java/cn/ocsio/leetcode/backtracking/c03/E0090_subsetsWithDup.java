package cn.ocsio.leetcode.backtracking.c03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/subsets-ii/
public class E0090_subsetsWithDup {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        E0090_subsetsWithDup e = new E0090_subsetsWithDup();
        List<List<Integer>> ans = e.subsetsWithDup(nums);
        System.out.println(ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return ans;
    }

    public void backtracking(int[] nums, int pos) {
        ans.add(new ArrayList<>(path));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
