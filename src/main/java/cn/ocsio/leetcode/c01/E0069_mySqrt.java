package cn.ocsio.leetcode.c01;

// https://leetcode.cn/problems/sqrtx/description/
public class E0069_mySqrt {
    public static void main(String[] args) {
        int x = 2147395599;
        E0069_mySqrt e = new E0069_mySqrt();
        int ans = e.mySqrt(x);
        System.out.println(ans);
    }

    public int mySqrt(int x) {
        int i = 0, j = x;
        int candidate = i;
        while (i <= j) {
            int mid = (i + j) >> 1;
            /*
                由于 mid * mid 可能超出 int 的表示范围而变为负数，导致死循环
                所以强转为 long
             */
            if ((long) mid * mid <= x) {
                candidate = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return candidate;
    }
}
