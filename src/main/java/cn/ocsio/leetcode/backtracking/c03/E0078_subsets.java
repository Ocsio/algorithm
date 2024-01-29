package cn.ocsio.leetcode.backtracking.c03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/subsets/
public class E0078_subsets {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        E0078_subsets e = new E0078_subsets();
        List<List<Integer>> ans = e.subsets(nums);
        System.out.println(ans);
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return ans;
    }

    /*
            [1,  2,  3]
            /    |    \
           1     2     3
          / \     \
        1,2 1,3   2,3
        /
      1,2,3
     */
    public void backtracking(int[] nums, int pos) {
        ans.add(new ArrayList<>(path));
        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
