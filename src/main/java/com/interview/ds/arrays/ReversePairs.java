package com.interview.ds.arrays;


//similar to count inversion
//count elements such that a[i] > 2* a[j] when i<j
//not exactly same as count inversion because in there if element at left> element at right everything
//in left after that element will be greater than right element and if left is not greater than we remove
//left_element from space
//however in reverse pair if left element is greater than 2* right element all element after left is greater
//but if it is not greater than 2* right element we remove right element from the space because it is smaller
//but it may happen that elements after the left elements can be 2* greater than right element.
//so thats why we need to check things beforehand only using right array. if element at right is such that
//multiplying by 2 still left element is greater than all the element before that right element becomes
//eligible for count which is right-(mid+1).

public class ReversePairs {
    public static void main(String[] args) {
        int[] arr = new int[]{40, 25, 19, 12, 9, 6, 2};
        System.out.println(divide(arr, 0, arr.length - 1));
    }

    private static int divide(int[] nums, int start, int end){
        int count = 0;
        if(start>=end){
            return count;
        }
        int mid = start + (end-start)/2;
        count+= divide(nums, start, mid);
        count+= divide(nums, mid+1, end);
        count+= merge(nums, start, mid, end);
        return count;
    }

    private static int merge(int[] nums, int start, int mid, int end){
        int left = start;
        int right = mid+1;
        int count = 0;


        //checking the condition of the question calculating count
        while(left<=mid){
            while(right<=end && nums[left]>2*nums[right]){
                right++;
            }
            count+= right-(mid+1);
            left++;
        }


        //normal merge
        left = start;
        right = mid+1;
        int[] temp = new int[end-start+1];
        int k = 0;
        while(left<=mid && right<=end){
            if(nums[left]<nums[right]){
                temp[k++] = nums[left++];
            }
            else{
                temp[k++] = nums[right++];
            }
        }

        while(left<=mid){
            temp[k++] = nums[left++];
        }

        while(right<=end){
            temp[k++] = nums[right++];
        }

        for(int i = start; i<=end; i++){
            nums[i] = temp[i-start];
        }
        return count;
    }
}
