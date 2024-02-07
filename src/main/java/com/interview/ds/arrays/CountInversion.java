package com.interview.ds.arrays;

//in arr[] find count of element such as a[i]>a[j] when i<j

// why merge sort??
//we merge two different sorted arrays into one array in merge step
// while merging we can check if element in the left is greater than the element at the right
//if yes then all the elements after that element will greater than that right element so we
//can count how many elements are there in the left element after the current element using
// mid(size of left)-i(current_element)+1, that will become the count for that merge. simply
//keep on adding the count of all merge and that will be our answer.


public class CountInversion {

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,2,4,1};
        System.out.println(countInversion(arr));
    }

    private static int countInversion(int[] arr){
        return count(arr, 0, arr.length-1);
    }

    private static int count(int[] arr, int left, int right){
        int count = 0;
        if(left>=right){
            return count;
        }
        int mid = left + (right-left)/2;
        count+=count(arr, left, mid);
        count+=count(arr, mid+1, right);
        count+=merge(arr, left, mid, right);

        return count;
    }



    //basic merge sort
    //only thing is when left > right that means everything after the left element is greater
    // than right element then count  = mid-left+1;
    private static int merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        int count = 0;
        while(i<=mid && j<=right){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }
            else{
                count+=mid-i+1;
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }

        while(j<=right){
            temp[k++] = arr[j++];
        }

        for(int l = left; l<=right; l++){
            arr[l] = temp[l-left];
        }

        return count;
    }
}
