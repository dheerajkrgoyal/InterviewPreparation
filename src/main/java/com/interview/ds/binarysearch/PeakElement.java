package com.interview.ds.binarysearch;

import java.util.Arrays;

/**
 * return index of the peak element.
 * peak element is the element that is greater than both of its neighbors. assume arr[-1] and arr[n]
 * is negative infinity. there can be multiple peaks, return any one.
 */
public class PeakElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,1,5,3};
        System.out.println(peak(arr));

        int[][] matrix = new int[][]{
                {10, 20, 15},
                {21, 30, 14},
                {7, 16, 32}
        };
        System.out.println(Arrays.toString(peak2D(matrix)));
    }

    private static int peak(int[] arr){
        if(arr.length == 1){
            return 0;
        }

        if(arr[0] > arr[1]){
            return 0;
        }

        if(arr[arr.length-1]>arr[arr.length-2]){
            return arr.length-1;
        }

        int low = 1;
        int high = arr.length-2;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid-1]<arr[mid] && arr[mid]> arr[mid+1]){
                return mid;
            }
            else if(arr[mid-1]>arr[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    /** peak in matrix is the element which greater than left, right, top and bottom element
     * assume all index out of bound element is -1;
     *
     * scan each column, find the max in the mid-column. and check left and right.
     * we do not check top and bottom because we pick max value of that column so it is bound to be
     * greater than top and bottom.
     * if that value is greater than left and right we found the peak element or else, we move
     * towards greater value
     * @param mat
     * @return
     */
    private static int[] peak2D(int[][] mat){
        int low = 0;
        int high = mat[0].length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int maxIndex = max(mat, mid);
            int left = mid - 1>=0? mat[maxIndex][mid-1]: -1;
            int right = mid+1<mat[0].length? mat[maxIndex][mid+1]: -1;
            if(mat[maxIndex][mid]>left && mat[maxIndex][mid]>right){
                return new int[]{maxIndex, mid};
            }
            else if(left > mat[maxIndex][mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return new int[]{-1, -1};
    }

    private static int max(int[][] mat, int col){
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i<mat.length; i++){
            if(mat[i][col]>maxValue){
                maxValue = mat[i][col];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
