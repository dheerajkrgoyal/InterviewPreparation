package com.interview.ds.binarysearch;

/**
 * Different variation of question if the array is sorted and rotated
 * 1. find element in rotated sorted array
 * 2. find element in rotated sorted array with duplicates
 * 3. find minimum in rotated sorted array
 * 4. find how many times array has been rotated
 */

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{12,15,18,2,4};
        int x = 2;
        System.out.println(search(arr, x));
        arr = new int[]{0,4,5,0,0,0,0};
        x = 4;
        System.out.println(searchWithDuplicates(arr, x));
        arr = new int[]{12,15,18,2,4};
        System.out.println(findMinimum(arr));
        System.out.println(rotationCount(arr));
    }

    private static int search(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[low]<=arr[mid]){
                if(arr[low]<=x && x<arr[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(arr[mid]<x && x<=arr[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    /**
     * only difference is if mid, low and high has same value which is not equal to the target
     * we trim down the search space until they become different, we increase the low and
     * decrease the high.
     * @param arr
     * @param x
     * @return
     */
    private static boolean searchWithDuplicates(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == x){
                return true;
            }
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
                continue;
            }

            else if(arr[low]<=arr[mid]){
                if(arr[low]<=x && x<arr[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(arr[mid]<x && x<=arr[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return false;
    }

    /**
     * we check which part is sorted if left is sorted meaning a[low]<=a[mid] then a[low] can be min
     * if right is sorted then a[mid] could be min
     * @param arr
     * @return
     */
    private static int findMinimum(int[] arr){
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[low]<=arr[mid]){
                min = Math.min(arr[low], min);
                low = mid+1;
            }
            else{
                min = Math.min(arr[mid], min);
                high = mid-1;
            }
        }
        return min;
    }

    /**
     * find the index of minimum value that will be the rotation count
     * @param arr
     * @return
     */
    private static int rotationCount(int[] arr){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[low]<=arr[mid]){
                if(arr[low]<min){
                    min = arr[low];
                    minIndex = low;
                }
                low = mid+1;
            }
            else{
                if(arr[mid]<min){
                    min = arr[mid];
                    minIndex = mid;
                }
                high = mid-1;
            }
        }
        return minIndex;
    }
}
