package cn.ocsio.leetcode.backtracking.c02;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/restore-ip-addresses/
public class E0093_restoreIpAddresses {
    List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        String s = "101023";
        E0093_restoreIpAddresses e = new E0093_restoreIpAddresses();
        List<String> ans = e.restoreIpAddresses(s);
        System.out.println(ans);
    }

    /**
     * 将 s 赋值给一个 StringBuilder，在该 StringBuilder 内部插 . 进行回溯
     */
    public List<String> restoreIpAddresses(String s) {
        backtracking(new StringBuilder(s), 0, 0);
        return ans;
    }

    public void backtracking(StringBuilder sb, int pos, int pointNum) {
        if (pointNum == 3) {
            if (isValid(sb, pos, sb.length() - 1)) {
                ans.add(sb.toString());
            }
        }
        for (int i = pos; i < sb.length(); i++) {
            if (isValid(sb, pos, i)) {
                sb.insert(i + 1, '.');
                backtracking(sb, i + 2, pointNum + 1);
                sb.deleteCharAt(i + 1);
            }
        }
    }

    public boolean isValid(StringBuilder sb, int start, int end) {
        if (start > end) {
            return false;
        }
        // 存在前导 0
        if (sb.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            int digit = sb.charAt(i) - '0';
            num = num * 10 + digit;
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
