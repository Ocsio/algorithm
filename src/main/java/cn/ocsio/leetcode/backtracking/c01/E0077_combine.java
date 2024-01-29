package cn.ocsio.leetcode.backtracking.c01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/combinations/description/
public class E0077_combine {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        E0077_combine e = new E0077_combine();
        int n = 4;
        int k = 2;
        List<List<Integer>> ans = e.combine(n, k);
        System.out.println(ans);
    }

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return ans;
    }

    public void backtracking(int n, int k, int start) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 剪枝优化
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
