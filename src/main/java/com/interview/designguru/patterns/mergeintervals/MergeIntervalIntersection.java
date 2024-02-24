package com.interview.designguru.patterns.mergeintervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of intervals, find the intersection of these two lists. Each list consists of
 * disjoint intervals sorted on their start time.
 *
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists.
 *
 * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
 * Output: [5, 7], [9, 10]
 * Explanation: The output list contains the common intervals between the two lists.
 */

public class MergeIntervalIntersection {

    static class Interval{
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + ']';
        }
    }

    public static void main(String[] args) {
        Interval[] arr1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        Interval[] arr2 = new Interval[]{new Interval(5,10)};

        System.out.println(merge(arr1, arr2));
    }

    public static List<Interval> merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        //loop till one of them reach the end
        while(i<arr1.length && j<arr2.length){

            //if two interval in i and j have some overlapping value
            if((arr1[i].start>=arr2[j].start && arr1[i].start<=arr2[j].end) ||
                    (arr2[j].start>=arr1[i].start && arr2[j].start<=arr1[i].end)){
                //add the overlapping value only
                result.add(new Interval(Math.max(arr1[i].start, arr2[j].start),
                        Math.min(arr1[i].end, arr2[j].end)));
            }

            //whatever is ending first move away from it.
            if(arr1[i].end<arr2[j].end){
                i++;
            }
            else{
                j++;
            }
        }

        return result;
    }
}
