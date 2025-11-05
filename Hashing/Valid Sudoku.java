class Solution {
    public boolean isValidSudoku(char[][] board) {
        // tracking arrays
        boolean[][] rows = new boolean[9][9];       // digit (1-9) per row
        boolean[][] columns = new boolean[9][9];    // digit (1-9) per column
        boolean[][] squares = new boolean[9][9];    // digit (1-9) per box

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';    //substract 1 to get index
                    int squareIndex = (i/3) * 3 + (j/3);

                    if (rows[i][num] || columns[j][num] || squares[squareIndex][num])
                        return false;
                
                    rows[i][num] = columns[j][num] = squares[squareIndex][num] = true;
                }
            }
        }

        return true;

        // explanation for the squareIndex formula:
        // int squareIndex = (i/3) * 3 + (j/3);
        // 1) First of, i/3 and j/3 - is integer (not float-point) division, resulting in
        // 2/3 -> 0; 1/3 -> 0; 0/3 -> 0; 2/3 -> 0

        // the sudoku squares are numbered left to right, top to bottom, as 
        // 0 1 2
        // 3 4 5
        // 6 7 8

        // i/3 determines which row block (top/middle/bottom) the cell is in.
        // j/3 determines which column block (left/middle/right) the cell is in.
        // the multiplication *3 of the row block by 3 allows to jump to the next row of boxes

    }
}