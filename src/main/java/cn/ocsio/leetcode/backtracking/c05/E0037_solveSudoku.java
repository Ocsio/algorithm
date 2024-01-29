package cn.ocsio.leetcode.backtracking.c05;

// https://leetcode.cn/problems/sudoku-solver/
public class E0037_solveSudoku {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        E0037_solveSudoku e = new E0037_solveSudoku();
        e.solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') {
                    continue;
                }
                for (char i = '1'; i <= '9'; i++) {
                    if (isValid(board, row, col, i)) {
                        board[row][col] = i;
                        if (backtracking(board)) {
                            return true;
                        }
                        board[row][col] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char ch) {
        // 同一行出现相同字符则 false
        for (int i = 0; i <= 9; i++) {
            if (board[row][i] == ch) {
                return false;
            }
        }
        // 同一列出现相同字符则 false
        for (int i = 0; i <= 9; i++) {
            if (board[i][col] == ch) {
                return false;
            }
        }
        // 同一个九宫格内出现相同字符则 false
        row = getActual(row);
        col = getActual(col);
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }

    // 返回比 num 小的数，该数是 3 的倍数
    public int getActual(int num) {
        num /= 3;
        return num * 3;
    }
}
