package cn.ocsio.leetcode.c01;

// https://leetcode.cn/problems/valid-perfect-square/description/
public class E0367_isPerfectSquare {
    public static void main(String[] args) {
        int num = 16;
        E0367_isPerfectSquare e = new E0367_isPerfectSquare();
        boolean ans = e.isPerfectSquare(num);
        System.out.println(ans);
    }

    public boolean isPerfectSquare(int num) {
        int i = 0, j = num;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if ((long) mid * mid < num) {
                i = mid + 1;
            } else if ((long) mid * mid > num) {
                j = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
