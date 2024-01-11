package cn.ocsio.leetcode.array.c02;

// https://leetcode.cn/problems/backspace-string-compare/
public class E0844_backspaceCompare {
    public static void main(String[] args) {
        String s = "#c";
        String t = "#c";
        E0844_backspaceCompare e = new E0844_backspaceCompare();
        boolean ans = e.backspaceCompare(s, t);
        System.out.println(ans);
    }

    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] == '#') {
                if (i > 0) {
                    i--;
                }
                j++;
            } else {
                arr[i++] = arr[j++];
            }
        }
        return new String(arr).substring(0, i);
    }
}
