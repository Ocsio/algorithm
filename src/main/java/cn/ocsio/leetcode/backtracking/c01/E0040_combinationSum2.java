package cn.ocsio.leetcode.backtracking.c01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/combination-sum-ii/
public class E0040_combinationSum2 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        E0040_combinationSum2 e = new E0040_combinationSum2();
        List<List<Integer>> ans = e.combinationSum2(candidates, target);
        System.out.println(ans);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1);
            path.removeLast();
        }
    }
}
