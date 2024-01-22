package cn.ocsio.leetcode.string.c02;

public class E0459_repeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "bb";
        E0459_repeatedSubstringPattern e = new E0459_repeatedSubstringPattern();
        boolean ans = e.repeatedSubstringPattern(s);
        System.out.println(ans);
    }

    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
