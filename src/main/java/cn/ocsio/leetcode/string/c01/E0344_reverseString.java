package cn.ocsio.leetcode.string.c01;

import java.util.Arrays;

// https://leetcode.cn/problems/reverse-string/
public class E0344_reverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l'};
        E0344_reverseString e = new E0344_reverseString();
        e.reverseString(s);
        System.out.println("s = " + Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i++, j--);
        }
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}