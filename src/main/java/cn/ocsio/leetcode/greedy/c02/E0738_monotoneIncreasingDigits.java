package cn.ocsio.leetcode.greedy.c02;


// https://leetcode.cn/problems/monotone-increasing-digits/
public class E0738_monotoneIncreasingDigits {

    public static void main(String[] args) {
        int n = 100;
        E0738_monotoneIncreasingDigits e = new E0738_monotoneIncreasingDigits();
        int ans = e.monotoneIncreasingDigits(n);
        System.out.println(ans);
    }

    public int monotoneIncreasingDigits(int n) {
        if (n == 0) {
            return n;
        }
        char[] chars = Integer.toString(n).toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] < chars[i - 1]) {
                set9(chars, i);
                chars[i - 1] -= 1;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public void set9(char[] chars, int i) {
        for (int idx = i; idx < chars.length; idx++) {
            chars[idx] = '9';
        }
    }
}
