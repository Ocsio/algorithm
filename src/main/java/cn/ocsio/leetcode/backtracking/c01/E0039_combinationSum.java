package cn.ocsio.leetcode.backtracking.c01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/combination-sum/
public class E0039_combinationSum {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        E0039_combinationSum e = new E0039_combinationSum();
        List<List<Integer>> ans = e.combinationSum(candidates, target);
        System.out.println(ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return ans;
    }

    public void backtracking(int[] candidates, int target, int pos) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i < candidates.length && target - candidates[i] >= 0; i++) {
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i);
            path.removeLast();
        }
    }
}
