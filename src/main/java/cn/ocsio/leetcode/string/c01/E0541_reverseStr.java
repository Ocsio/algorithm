package cn.ocsio.leetcode.string.c01;

public class E0541_reverseStr {
    public static void main(String[] args) {
        String s = "abcdefgh";
        int k = 3;
        E0541_reverseStr e = new E0541_reverseStr();
        String ans = e.reverseStr(s, k);
        // bacdfeg
        System.out.println(ans);
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return s;
        }
        // 若字符串凑不成一组，则反转全部
        if (k > chars.length) {
            reverse(chars, 0, chars.length - 1);
            return new String(chars);
        }
        for (int i = 0; i < chars.length; i += 2 * k) {
            int right = (i + k - 1 < chars.length) ? i + k - 1 : chars.length - 1;
            reverse(chars, i, right);
        }
        return new String(chars);
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
