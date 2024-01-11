package cn.ocsio.leetcode.array.c04;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/spiral-matrix/
public class E0054_spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        E0054_spiralOrder e = new E0054_spiralOrder();
        List<Integer> ans = e.spiralOrder(matrix);
        System.out.println("ans = " + ans);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, m = matrix.length - 1, n = matrix[0].length - 1;
        while (i <= m && j <= n) {
            helper(ans, matrix, i++, j++, m--, n--);
        }
        return ans;
    }

    public void helper(List<Integer> ans, int[][] matrix, int i, int j, int m, int n) {
        if (i == m) {
            for (int t = j; t <= n; t++) {
                ans.add(matrix[i][t]);
            }
        } else if (j == n) {
            for (int t = i; t <= m; t++) {
                ans.add(matrix[t][j]);
            }
        } else {
            int ci = i;
            int cj = j;
            // 右移
            while (cj != n) {
                ans.add(matrix[i][cj++]);
            }
            // 下移
            while (ci != m) {
                ans.add(matrix[ci++][cj]);
            }
            // 左移
            while (cj != j) {
                ans.add(matrix[m][cj--]);
            }
            // 上移
            while (ci != i) {
                ans.add(matrix[ci--][cj]);
            }
        }
    }
}
