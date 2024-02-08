package com.interview.ds.binarysearch;

/**
 * For given array if array does not miss any no. let's say size  = 4 then array would be [1,2,3,4]
 * since array is missing some no. array is [2,3,7,11]
 * we calculate how many nos. are missing at each index by subtracting value at the index and value that should
 * have been present at that index [2,3,7,11]-[1,2,3,4] = [1,1,4,7];
 * Since we need to find 6th missing no. the value should be present between 7 and 11. why?
 * coz until 7 only 4 nos. are missing so we cannot find 6th no. and until 11, 7 nos. are missing so value must
 * be less that 11 and greater than 7
 *
 * using above observation we run binary search based on no. of missing nos.
 * when low and high crosses, high will be at 7(index 2);
 * since 4 values are missing at index 2, we need to find +2 nos.
 * which is 7+2 = 9;
 * in formula arr[high] + (k-missing at high index)
 * arr[high] + (k - (arr[high]-(high+1)))
 * arr[high] + k - arr[high] + high + 1
 * return k+ high+ 1
 */
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] vec = new int[]{2,3,7,11}; //array should have been [1,2,3,4] missing = [1,4,5,6,8,9,10]
        //how many nos. are missing till each index [1,1,4,7];
        int k = 6;
        int n = 4;
        System.out.println(missingK(vec, n, k));
    }

    public static int missingK(int[] vec, int n, int k) {
        //index low = 0 high= arr.length-1
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;

            //find how many nos. are missing at mid index
            //if it is less than k we move low or else move high
            if(vec[mid]-(mid+1)<k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        //once high crosses low missing no is high+1+k
        return k+ high + 1;
    }
}
