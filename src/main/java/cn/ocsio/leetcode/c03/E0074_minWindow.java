package cn.ocsio.leetcode.c03;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/minimum-window-substring/
public class E0074_minWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        E0074_minWindow e = new E0074_minWindow();
        String ans = e.minWindow(s, t);
        System.out.println("ans = " + ans);
    }

    public String minWindow(String s, String t) {
        // start 表示最小覆盖子串的起始位置，len 表示最小覆盖子串的长度
        int start = 0;
        int len = Integer.MAX_VALUE;
        // 对 t 串进行词频统计
        HashMap<Character, Integer> fre_t = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            fre_t.put(t.charAt(i), fre_t.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 对 s 串进行滑动窗口算法
        int winL = 0;
        HashMap<Character, Integer> fre_s = new HashMap<>();
        for (int winR = 0; winR < s.length(); winR++) {
            fre_s.put(s.charAt(winR), fre_s.getOrDefault(s.charAt(winR), 0) + 1);
            while (check(fre_s, fre_t)) {
                if (len > winR - winL + 1) {
                    len = winR - winL + 1;
                    start = winL;
                }
                fre_s.put(s.charAt(winL), fre_s.get(s.charAt(winL)) - 1);
                winL++;
            }
        }
        return (len != Integer.MAX_VALUE) ? s.substring(start, start + len) : "";
    }

    public boolean check(HashMap<Character, Integer> s, HashMap<Character, Integer> t) {
        for (Map.Entry<Character, Integer> e : t.entrySet()) {
            if (!s.containsKey(e.getKey()) || s.get(e.getKey()) < t.get(e.getKey())) {
                return false;
            }
        }
        return true;
    }
}
