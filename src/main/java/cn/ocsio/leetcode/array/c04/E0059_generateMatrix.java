package cn.ocsio.leetcode.array.c04;

import cn.ocsio.utils.Print;

import java.util.Arrays;

// https://leetcode.cn/problems/spiral-matrix-ii/
public class E0059_generateMatrix {
    public static void main(String[] args) {
        int n = 3;
        E0059_generateMatrix e = new E0059_generateMatrix();
        int[][] ans = e.generateMatrix(n);
        Print.print(ans);
    }

    public int[][] generateMatrix(int k) {
        int[][] ans = new int[k][k];
        int adder = 1;
        int i = 0, j = 0, m = k - 1, n = k - 1;
        while (i <= m && j <= n) {
            adder = helper(adder, ans, i++, j++, m--, n--);
        }
        return ans;
    }

    private int helper(int adder, int[][] ans, int i, int j, int m, int n) {
        if (i == m) {
            for (int t = j; t <= n; t++) {
                ans[i][t] = adder++;
            }
        } else if (j == n) {
            for (int t = i; t <= m; t++) {
                ans[t][j] = adder++;
            }
        } else {
            int ci = i;
            int cj = j;
            // 右移
            while (cj != n) {
                ans[i][cj++] = adder++;
            }
            // 下移
            while (ci != m) {
                ans[ci++][cj] = adder++;
            }
            // 左移
            while (cj != j) {
                ans[m][cj--] = adder++;
            }
            // 上移
            while (ci != i) {
                ans[ci--][cj] = adder++;
            }
        }
        return adder;
    }
}
