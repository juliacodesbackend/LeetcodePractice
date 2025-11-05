class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // tracking arrays
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] squares = new boolean[9][9];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int arraysIndex;
                int squareIndex;
                if (Character.isDigit(board[i][j])) {
                    arraysIndex = Character.getNumericValue(board[i][j]) - 1; //substract 1 to get index
                    squareIndex = (i/3) * 3 + (j/3);
                } else
                    continue;

                if (rows[i][arraysIndex] || 
                columns[j][arraysIndex] || 
                squares[squareIndex][arraysIndex])
                    return false;
                else
                    rows[i][arraysIndex] = columns[j][arraysIndex] = squares[squareIndex][arraysIndex] = true;
            }
        }
        

        return true;
    }
}