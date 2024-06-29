package com.interview.ds.arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,7,8,3};
        System.out.println(secondLargest1(arr));
    }

    //2 pass solution. we iterate through the array 2 times
    @SuppressWarnings("unused")
    private static int secondLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            largest = Math.max(arr[i], largest);
        }

        int secondLargest = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    //1 pass solution
    private static int secondLargest1(int[] arr){
        int largest = arr[0];
        int secondLargest = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i]< largest && arr[i] > secondLargest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
