package cn.ocsio.leetcode.backtracking.c02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/palindrome-partitioning/
public class E0131_partition {
    List<List<String>> ans = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public static void main(String[] args) {
        String s = "aab";
        E0131_partition e = new E0131_partition();
        List<List<String>> ans = e.partition(s);
        System.out.println(ans);
    }

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return ans;
    }

    public void backtracking(String s, int pos) {
        if (pos > s.length()) {
            return;
        }
        if (pos == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                String sub = s.substring(pos, i + 1);
                path.add(sub);
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
