package com.interview.designguru.patterns.mergeintervals;

import java.util.*;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a list
 * that has only mutually exclusive intervals.
 *
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into one [1,5].
 *
 * Intervals: [[6,7], [2,4], [5,9]]
 * Output: [[2,4], [5,9]]
 * Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
 */

public class MergeIntervals {

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
                new Interval(1,4),
                new Interval(2,5),
                new Interval(7,9)
        ));

        System.out.println(merge(intervals));
    }


    public static List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> mergedIntervals = new LinkedList<>();
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        for (int i = 0; i < intervals.size(); i++) {
            if (mergedIntervals.isEmpty() || mergedIntervals.getLast().end < intervals.get(i).start) {
                mergedIntervals.add(intervals.get(i));
            } else {
                mergedIntervals.getLast().end = Math.max(mergedIntervals.getLast().end, intervals.get(i).end);
            }
        }
        return mergedIntervals;
    }
}
