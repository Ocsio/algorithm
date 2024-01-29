package cn.ocsio.leetcode.backtracking.c05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/n-queens/
public class E0051_solveNQueens {
    List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        E0051_solveNQueens e = new E0051_solveNQueens();
        List<List<String>> ans = e.solveNQueens(n);
        System.out.println(ans);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        for (char[] chs : chars) {
            Arrays.fill(chs, '.');
        }
        backtracking(chars, n, 0);
        return ans;
    }

    public void backtracking(char[][] chessboard, int n, int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : chessboard) {
                list.add(new String(chars));
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(chessboard, row, col, n)) {
                chessboard[row][col] = 'Q';
                backtracking(chessboard, n, row + 1);
                chessboard[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] chessboard, int row, int col, int n) {
        // 当前列有皇后则不能放
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 135 度方向有皇后则不能放
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 45 度方向有皇后则不能放
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
