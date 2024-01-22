package cn.ocsio.leetcode.string.c01;

// https://leetcode.cn/problems/reverse-words-in-a-string/
public class E0151_reverseWords {
    public static void main(String[] args) {
        String s = "  the  sky is blue  ";
        E0151_reverseWords e = new E0151_reverseWords();
        String ans = e.reverseWords(s);
        System.out.println(ans);
    }

    public int removeExtraSpaces(char[] chars) {
        // 去掉头尾和中间冗余的空格
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {
                if (slow != 0) {
                    chars[slow++] = ' ';
                }
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
            }
        }
        return slow;
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        // len 表示有效字符串的长度
        int len = removeExtraSpaces(chars);
        // 反转整个有效字符串
        reverse(chars, 0, len - 1);
        int i = 0;
        for (int j = 0; j <= len; j++) {
            if (j == len || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
        }
        return new String(chars).substring(0, len);
    }

    public void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
