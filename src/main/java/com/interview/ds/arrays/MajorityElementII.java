package com.interview.ds.arrays;

import java.util.ArrayList;
import java.util.List;

//return the element whose count is more than n/3;
public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 2, 2, 2};
        System.out.println(majority(arr));
    }

    /**
     * At max there can be 2 elements whose frequency is greater than floor of n/3 in any array
     * Very well we can do it using frequency map which will take extra o(n) space.
     * but we can also do it using moore's voting algorithm since we already know there can be at max 2 element
     * just slight vary the algo
     * @param arr
     * @return
     */
    private static List<Integer> majority(int[] arr){
        List<Integer> res = new ArrayList<>();
        int cnt1 = 0; int cnt2 = 0;
        int ele1 = -1; int ele2 = -1;
        for(int i = 0; i<arr.length; i++){
            if(cnt1 == 0 && arr[i] != ele2){
                cnt1++;
                ele1 = arr[i];
            }
            else if(cnt2 == 0 && arr[i] != ele1){
                cnt2++;
                ele2 = arr[i];
            }
            else if(ele1 == arr[i]){
                cnt1++;
            }
            else if(ele2 == arr[i]){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0; i<arr.length; i++){
            if(ele1 == arr[i]){
                cnt1++;
            }
            if(ele2 == arr[i]){
                cnt2++;
            }
        }

        if(cnt1>(arr.length/3)){
            res.add(ele1);
        }
        if(cnt2>(arr.length/3)){
            res.add(ele2);
        }

        return res;
    }
}
