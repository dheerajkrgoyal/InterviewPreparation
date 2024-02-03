package com.interview.ds.binarysearch;

/**
 * Each row is sorted
 * and row and col no. are odd
 * imagine it to be sorted 1D array for median the no. of left element should be n*m/2
 * thats what we are finding
 * a median/element can be between min and max element of the array which becomes high and low of a binary search
 * for each mid we count how many nos are smaller than that mid if it is greater than m*n/2 than that becomes
 * probable median.
 *  inorder to count smaller no. we again do binary search on each row;
 */
public class MedianOfMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 5, 7, 9, 11},
                {2, 3, 4, 8, 9},
                {4, 11, 14, 19, 20},
                {6, 10, 22, 99, 100},
                {7, 15, 17, 24, 28}
        };
        System.out.println(findMedian(matrix, 5, 5));
    }

    private static int findMedian(int matrix[][], int m, int n) {
        // Write your code here
        int low = min(matrix, m);
        int high = max(matrix, m);
        int reqd = (m * n) / 2;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countSmaller(matrix, m, n, mid);
            if (count > reqd) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static int min(int[][] matrix, int row) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            min = Math.min(min, matrix[i][0]);
        }
        return min;
    }

    private static int max(int[][] matrix, int row) {
        int max = Integer.MIN_VALUE;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            max = Math.max(max, matrix[i][col - 1]);
        }
        return max;
    }

    private static int countSmaller(int[][] matrix, int row, int col, int x) {
        int count = 0;
        for (int i = 0; i < row; i++) {
            int low = 0;
            int high = col - 1;
            int ans = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (matrix[i][mid] <= x) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid-1;
                }
            }
            if (ans != -1) {
                count += (ans + 1);
            }
        }
        return count;
    }
}
