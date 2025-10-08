package DSA_with_kunal.Recursion.concept.BackTracking.WordSearch;

class Solution {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word="ABCCED";
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, String word, int row, int col, int idx) {
        if (idx >= word.length()) {
            return true;
        }
        if (col < 0 || row < 0 || col >= board[0].length || row >= board.length
                || board[row][col] != word.charAt(idx)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '$';
        boolean found = helper(board, word, row, col + 1, idx + 1) || helper(board, word, row, col - 1, idx + 1)
                || helper(board, word, row + 1, col, idx + 1) || helper(board, word, row - 1, col, idx + 1);
        board[row][col] = temp;
        return found;
    }
}
