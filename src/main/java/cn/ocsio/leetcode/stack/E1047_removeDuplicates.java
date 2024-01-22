package cn.ocsio.leetcode.stack;

public class E1047_removeDuplicates {
    public static void main(String[] args) {
        String s = "abbaca";
        E1047_removeDuplicates e = new E1047_removeDuplicates();
        String ans = e.removeDuplicates(s);
        System.out.println(ans);
    }

    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (top > -1 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(ch);
                top++;
            }
        }
        return stack.toString();
    }
}
