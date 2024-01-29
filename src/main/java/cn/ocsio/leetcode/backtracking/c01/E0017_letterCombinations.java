package cn.ocsio.leetcode.backtracking.c01;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
public class E0017_letterCombinations {
    String[] letterMap = new String[]{
            "", "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public static void main(String[] args) {
        String digits = "23";
        E0017_letterCombinations e = new E0017_letterCombinations();
        List<String> ans = e.letterCombinations(digits);
        System.out.println(ans);
    }

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return ans;
        }
        backtracking(digits, 0);
        return ans;
    }

    public void backtracking(String digits, int pos) {
        if (pos == digits.length()) {
            ans.add(new String(path));
            return;
        }
        int index = Integer.parseInt(String.valueOf(digits.charAt(pos)));
        for (int i = 0; i < letterMap[index].length(); i++) {
            path.append(letterMap[index].charAt(i));
            backtracking(digits, pos + 1);
            path.deleteCharAt(pos);
        }
    }
}
