package com.interview.ds.arrays;

import java.util.Arrays;

public class PascalsTriangle {
    /**
     * There are 3 kind of problems which can be asked in Pascals Triangle
     * 1. Given row and column return the element of the pascals triangle
     * 2. Given row no. return the entire row of the pascals triangle
     * 3. Given row no. return the entire pascals triangle till that row
     * Assume row and col no. are 1- indexed.
     */
    public static void main(String[] args) {
        int row = 5;
        int col = 3;
        System.out.println(pascalValue(row, col));
        System.out.println(Arrays.toString(generateRowPascal(row)));
        System.out.println(Arrays.deepToString(generateTriangle(row)));
    }

    //the value of element in pascal triangle is the formula nCr or row-1Ccol-1
    private static int pascalValue(int row, int col){
        //nCr
        int n = row-1;
        int r = col-1;
        int ans = 1;
        for(int i=0; i<r; i++){
            ans = (ans*(n-i))/(i+1);
        }
        return ans;
    }

    //5th row is 1, 4, 6, 4, 1 can be written as
    // 1 , 1 * (4/1), 4 * (3/2), 6 * (2/3), 4 * (1/4)
    //so we can see the pattern above
    private static int[] generateRowPascal(int row){
        int[] res = new int[row];
        res[0] = 1;
        for(int i=1; i<row; i++){
            res[i] = (res[i-1]*(row-i))/i;
        }
        return res;
    }

    private static int[][] generateTriangle(int row){
        int[][] res = new int[row][];
        for(int i = 1; i<= row; i++){
            res[i-1] = generateRowPascal(i);
        }
        return res;
    }
}
