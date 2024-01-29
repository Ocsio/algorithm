package cn.ocsio.leetcode.backtracking.c04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/permutations-ii/
public class E0047_permuteUnique {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        E0047_permuteUnique e = new E0047_permuteUnique();
        List<List<Integer>> ans = e.permuteUnique(nums);
        System.out.println(ans);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums);
        return ans;
    }

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && !used[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            used[i] = false;
            path.removeLast();
        }
    }
}
