package cn.ocsio.leetcode.hash.c01;

// https://leetcode.cn/problems/ransom-note/
public class E0383_canConstruct {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        E0383_canConstruct e = new E0383_canConstruct();
        boolean ans = e.canConstruct(ransomNote, magazine);
        System.out.println("ans = " + ans);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] fre = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            fre[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--fre[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
