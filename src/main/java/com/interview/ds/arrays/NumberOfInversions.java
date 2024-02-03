package com.interview.ds.arrays;

//Find count of element where i<j and arr[i]>arr[j]
public class NumberOfInversions {

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1};
        System.out.println(divide(arr, 0, arr.length - 1));
    }

    private static int divide(int[] a, int start, int end){
        int cnt = 0;
        if(start >= end){
            return cnt;
        }
        int mid = start + (end-start)/2;
        cnt += divide(a, start, mid);
        cnt += divide(a, mid+1, end);
        cnt += merge(a, start, mid, end);
        return cnt;
    }


    private static int merge(int[] a, int start, int mid, int end){
        int left = start;
        int right = mid+1;
        int[] temp = new int[end-start+1];
        int k = 0;
        int count = 0;
        while(left<=mid && right<=end){
            if(a[left] > a[right]){
                count+=mid-left+1;
                temp[k++] = a[right];
                right++;
            }
            else{
                temp[k++] = a[left];
                left++;
            }
        }

        while(left<=mid){
            temp[k++] = a[left++];
        }

        while(right<=end){
            temp[k++] = a[right++];
        }

        for(int i = start; i<=end; i++){
            a[i] = temp[i-start];
        }

        return count;
    }
}
