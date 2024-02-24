package com.interview.designguru.patterns.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a list of non-overlapping intervals sorted by their start time, insert a given interval at
 * the correct position and merge all necessary intervals to produce a list that has only mutually
 * exclusive intervals.
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
 * Output: [[1,3], [4,12]]
 * Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
 */

public class InsertInterval {
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

        List<Interval> intervals = new ArrayList<>(Arrays.asList(
                new Interval(1, 3),
                new Interval(5,7),
                new Interval(8,12)
        ));

        System.out.println(insert(intervals, new Interval(4,10)));
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;

        //when intervals ends before new interval starts
        while(i<intervals.size() && intervals.get(i).end<newInterval.start){
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        //when intervals starts before new intervals ends that means it will overlap
        //continue looping through i until you find overlap and keep on expanding the
        //new interval value
        while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        mergedIntervals.add(newInterval);

        //all merging of overlap intervals are done and if more non-overlapping intervals are left
        while(i< intervals.size()){
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        return mergedIntervals;
    }
}
