package com.interview.ds.arrays;

//return the element whose count is more than n/2;
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
        System.out.println(majorityElement(arr));
    }

    //we can do it using frequency map very well which uses o(n) space
    //lets do it in o(n) time and o(1) space
    //Moore's voting algorithm
    private static int majorityElement(int[] arr){
        int majorityElement = 0;
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            if(count == 0){
                majorityElement = arr[i];
                count ++;
            }
            else{
                if(majorityElement == arr[i]){
                    count++;
                }
                else{
                    count--;
                }
            }
        }
        return majorityElement;
    }
}
