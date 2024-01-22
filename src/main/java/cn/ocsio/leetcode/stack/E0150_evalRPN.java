package cn.ocsio.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class E0150_evalRPN {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        E0150_evalRPN e = new E0150_evalRPN();
        int ans = e.evalRPN(tokens);
        System.out.println(ans);
    }

    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    String op2 = stack.pop();
                    String op1 = stack.pop();
                    stack.push(String.valueOf(Integer.parseInt(op1) + Integer.parseInt(op2)));
                    break;
                }
                case "-": {
                    String op2 = stack.pop();
                    String op1 = stack.pop();
                    stack.push(String.valueOf(Integer.parseInt(op1) - Integer.parseInt(op2)));
                    break;
                }
                case "*": {
                    String op2 = stack.pop();
                    String op1 = stack.pop();
                    stack.push(String.valueOf(Integer.parseInt(op1) * Integer.parseInt(op2)));
                    break;
                }
                case "/": {
                    String op2 = stack.pop();
                    String op1 = stack.pop();
                    stack.push(String.valueOf(Integer.parseInt(op1) / Integer.parseInt(op2)));
                    break;
                }
                default:
                    stack.push(token);
                    break;
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
