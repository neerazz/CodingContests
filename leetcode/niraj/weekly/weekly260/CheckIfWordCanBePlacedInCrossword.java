package weekly.weekly260;

/**
 * Created on:  Sep 25, 2021
 * Ref:
 */
public class CheckIfWordCanBePlacedInCrossword {
    public static void main(String[] args) {
        System.out.println(placeWordInCrossword(new char[][]{{'#', ' ', '#'}, {' ', ' ', '#'}, {'#', 'c', ' '}}, "abc") + " = true");
        System.out.println(placeWordInCrossword(new char[][]{{' ', '#', 'a'}, {' ', '#', 'c'}, {' ', '#', 'a'}}, "ac") + " = false");
    }

    public static boolean placeWordInCrossword(char[][] board, String word) {
        int rows = board.length, cols = rows > 0 ? board[0].length : 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isPossible(board, word, row, col, rows, cols)) {
//                    System.out.println("row = " + row + " col = " + col);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isPossible(char[][] grid, String word, int row, int col, int rows, int cols) {
//        The start character should not '#'
        if (grid[row][col] == '#') return false;
//        Check if word can be placed in left direction. For that you have to check if the right element of starting point should be either out of index, or should be '#'
        if (isValid(grid, row, col + 1, rows, cols) && isPossible(grid, word, row, col, rows, cols, 0, -1)) return true;
//        Check if word can be placed in right direction. For that you have to check if the right element of starting point should be either out of index, or should be '#'
        if (isValid(grid, row, col - 1, rows, cols) && isPossible(grid, word, row, col, rows, cols, 0, 1)) return true;
//        Check if word can be placed in top direction. For that you have to check if the bottom element of starting point should be either out of index, or should be '#'
        if (isValid(grid, row + 1, col, rows, cols) && isPossible(grid, word, row, col, rows, cols, -1, 0)) return true;
//        Check if word can be placed in bottom direction. For that you have to check if the top element of starting point should be either out of index, or should be '#'
        return isValid(grid, row - 1, col, rows, cols) && isPossible(grid, word, row, col, rows, cols, 1, 0);
    }

    static boolean isPossible(char[][] board, String word, int row, int col, int rows, int cols, int d1, int d2) {
        int i = 0, len = word.length();
        while (i < len && inRange(row, col, rows, cols) && (board[row][col] == ' ' || board[row][col] == word.charAt(i))) {
            row += d1;
            col += d2;
            i++;
        }
//        If all characters are not travelled in the word
        if (i < len) return false;
//        The ending char should be valid, either out of index or '#'
        return isValid(board, row, col, rows, cols);
    }

    static boolean inRange(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    static boolean isValid(char[][] board, int row, int col, int rows, int cols) {
//        Is to check the left and right element is valid, when placing horizontally. And vise-versa
        if (inRange(row, col, rows, cols)) return board[row][col] == '#';
        return true;
    }

    static void buildLeft(char[][] board, int rows, int cols, int[][] dp) {
        for (int row = 0; row < rows; row++) {
            int count = 0;
            for (int col = 0; col < cols; col++) {
                count = board[row][col] == '#' ? 0 : count + 1;
                dp[row][col] = count;
            }
        }
    }

    static void buildRight(char[][] board, int rows, int cols, int[][] dp) {
        for (int row = 0; row < rows; row++) {
            int count = 0;
            for (int col = cols - 1; col >= 0; col--) {
                count = board[row][col] == '#' ? 0 : count + 1;
                dp[row][col] = count;
            }
        }
    }

    static void buildTop(char[][] board, int rows, int cols, int[][] dp) {
        for (int col = 0; col < cols; col++) {
            int count = 0;
            for (int row = 0; row < rows; row++) {
                count = board[row][col] == '#' ? 0 : count + 1;
                dp[row][col] = count;
            }
        }
    }

    static void buildDown(char[][] board, int rows, int cols, int[][] dp) {
        for (int col = 0; col < cols; col++) {
            int count = 0;
            for (int row = rows - 1; row >= 0; row--) {
                count = board[row][col] == '#' ? 0 : count + 1;
                dp[row][col] = count;
            }
        }
    }
}
