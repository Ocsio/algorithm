package cn.ocsio.leetcode.hash.c01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/find-all-anagrams-in-a-string/
public class E0438_findAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        E0438_findAnagrams e = new E0438_findAnagrams();
        List<Integer> ans = e.findAnagrams(s, p);
        System.out.println("ans = " + ans);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        int[] fre_p = new int[26];
        int[] fre_s = new int[26];
        for (int i = 0; i < p.length(); i++) {
            fre_p[p.charAt(i) - 'a']++;
            fre_s[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(fre_s, fre_p)) {
            ans.add(0);
        }
        int winL = 0;
        for (int winR = p.length(); winR < s.length(); winR++) {
            fre_s[s.charAt(winR) - 'a']++;
            fre_s[s.charAt(winL++) - 'a']--;
            if (Arrays.equals(fre_s, fre_p)) {
                ans.add(winL);
            }
        }
        return ans;
    }
}
