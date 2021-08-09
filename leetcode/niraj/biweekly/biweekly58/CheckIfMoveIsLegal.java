package niraj.biweekly.biweekly58;

import java.util.*;

/**
 * Created on:  Aug 07, 2021
 * Ref : https://leetcode.com/contest/biweekly-contest-58/problems/check-if-move-is-legal/
 */
public class CheckIfMoveIsLegal {
    public static void main(String[] args) {
        System.out.println(checkMove(new char[][]{{'.','.','.','.','.','.','.','.'},{'.','B','.','.','W','.','.','.'},{'.','.','W','.','.','.','.','.'},{'.','.','.','W','B','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','B','W','.','.'},{'.','.','.','.','.','.','W','.'},{'.','.','.','.','.','.','.','B'}},
                4, 4, 'W') + " = false");
        System.out.println(checkMove(new char[][]{{'W','W','.','B','.','B','B','.'},{'W','B','.','.','W','B','.','.'},{'B','B','B','B','W','W','B','.'},{'W','B','.','.','B','B','B','.'},{'W','W','B','.','W','.','B','B'},{'B','.','B','W','.','B','.','.'},{'.','B','B','W','B','B','.','.'},{'B','B','W','.','.','B','.','.'}},
                7, 4, 'B') + " = true");
        System.out.println(checkMove(new char[][]{{'.','.','.','B','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'W','B','B','.','W','W','W','B'},{'.','.','.','B','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','W','.','.','.','.'}},
                4, 3, 'B') + " = true");
        System.out.println(checkMove(new char[][]{{'.', '.', '.', '.', 'W', 'B', 'B', 'B'}, {'.', '.', '.', '.', '.', '.', '.', 'B'}, {'W', '.', '.', 'W', '.', '.', 'W', '.'}, {'B', '.', 'B', 'B', 'B', '.', '.', 'W'}, {'W', '.', '.', 'B', 'W', 'B', 'B', '.'}, {'W', 'B', '.', '.', 'W', 'B', 'B', '.'}, {'.', 'W', 'B', 'B', 'W', 'B', '.', 'W'}, {'B', '.', 'W', 'B', 'W', '.', 'W', '.'}},
                0, 0, 'B') + " = false");
    }

    public static boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        board[rMove][cMove] = color;
        int[] dirs = {-1, 0, 1};
        for (int d1 : dirs) {
            for (int d2 : dirs) {
                if (d1 == 0 && d2 == 0) continue;
                if (move(board, rMove, cMove, new int[]{d1, d2}, color)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean move(char[][] board, int row, int col, int[] dirs, char color) {
        int total = 0;
        row += dirs[0];
        col += dirs[1];
        Set<Character> mids = new HashSet<>();
//
        while (inBound(row, col, board) && board[row][col] != '.' && board[row][col] != color && mids.size() < 2) {
            total++;
            mids.add(board[row][col]);
            row += dirs[0];
            col += dirs[1];
        }
        return total >= 1 && mids.size() == 1 && inBound(row, col, board) && board[row][col] == color;
    }

    private static boolean inBound(int row, int col, char[][] board) {
        return row >= 0 && row < board.length && col >=0 && col < board[0].length;
    }
}
