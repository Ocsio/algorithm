package cn.ocsio.leetcode.backtracking.c01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E0216_combinationSum3 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        E0216_combinationSum3 e = new E0216_combinationSum3();
        int k = 3;
        int n = 7;
        List<List<Integer>> ans = e.combinationSum3(k, n);
        System.out.println(ans);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return ans;
    }

    public void backtracking(int k, int n, int start) {
        if (n < 0) {
            return;
        }
        if (path.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }
            return;
        }
        for (int i = start; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(k, n - i, i + 1);
            path.removeLast();
        }
    }
}
