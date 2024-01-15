package cn.ocsio.leetcode.hash.c01;

// https://leetcode.cn/problems/valid-anagram/
public class E0242_isAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        E0242_isAnagram e = new E0242_isAnagram();
        boolean ans = e.isAnagram(s, t);
        System.out.println("ans = " + ans);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] fre = new int[26];
        for (int i = 0; i < s.length(); i++) {
            fre[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--fre[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
