package com.interview.ds.recursion;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(nQueen(new boolean[n][n], 0));
    }

    static int nQueen(boolean[][] board, int row){
        int count  = 0;
        if(row == board.length){
            return 1;
        }

        for(int i = 0; i<board[0].length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = true;
                count+= nQueen(board, row+1);
                board[row][i] = false;
            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int r, int c){
        int i = r;

        //check vertically
        while(i>=0){
            if(board[i][c]){
                return false;
            }
            i--;
        }

        i = r;
        int j = c;
        while(i>=0 && j>=0){
            if(board[i][j]){
                return false;
            }
            i--;
            j--;
        }

        i = r;
        j = c;
        while(i>=0 && j<=board[0].length-1){
            if(board[i][j]){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
