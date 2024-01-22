package cn.ocsio.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class E0020_isValid {
    public static void main(String[] args) {
        String s = "([}}])";
        E0020_isValid e = new E0020_isValid();
        boolean ans = e.isValid(s);
        System.out.println(ans);
    }

    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else {
                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
