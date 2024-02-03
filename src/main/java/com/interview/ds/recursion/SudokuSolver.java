package com.interview.ds.recursion;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        sudoku(board, 0 , 0);
        System.out.println(Arrays.deepToString(board));
    }

    static boolean sudoku(char[][] board, int row, int col){
        if(row == board.length){
            return true;
        }

        if(col == board[0].length){
            return sudoku(board, row+1, 0);
        }

        if(board[row][col] == '.'){
            for(char c = '1'; c <= '9'; c++){
                if(isSafe(board, row, col, c)){
                    board[row][col] = c;
                    boolean result = sudoku(board, row, col+1);
                    if(result){
                        return true;
                    }
                    else{
                        board[row][col] = '.';
                    }
                }
            }
        }
        else{
            return sudoku(board, row, col+1);
        }
        return false;
    }

    static boolean isSafe(char[][] board, int row, int col, char c){
        for(int i = 0; i< board.length; i++){
            if(board[row][i] == c){
                return false;
            }
        }

        for(int i = 0; i< board[0].length; i++){
            if(board[i][col] == c) {
                return false;
            }
        }

        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;
        for(int i = rowStart; i<rowStart+sqrt; i++){
            for(int j = colStart; j< colStart+sqrt; j++){
                if(board[i][j] == c){
                    return false;
                }
            }
        }
        return true;
    }
}
