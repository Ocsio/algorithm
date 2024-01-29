package cn.ocsio.leetcode.backtracking.c04;

import java.util.*;

// https://leetcode.cn/problems/permutations/description/
public class E0046_permute {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        E0046_permute e = new E0046_permute();
        List<List<Integer>> ans = e.permute(nums);
        System.out.println(ans);
    }

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return ans;
    }

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            path.add(num);
            set.add(num);
            backtracking(nums);
            path.removeLast();
            set.remove(num);
        }
    }
}
