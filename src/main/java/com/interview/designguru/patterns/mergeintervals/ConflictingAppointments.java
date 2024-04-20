package com.interview.designguru.patterns.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the
 * appointments.
 *
 * Example 1:
 *
 * Appointments: [[1,4], [2,5], [7,9]]
 * Output: false
 * Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
 * Example 2:
 *
 * Appointments: [[6,7], [2,4], [8,12]]
 * Output: true
 * Explanation: None of the appointments overlap, therefore a person can attend all of them.
 * Example 3:
 *
 * Appointments: [[4,5], [2,3], [3,6]]
 * Output: false
 * Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
 */
public class ConflictingAppointments {

    static class Interval{
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        Interval[] intervals = new Interval[]{new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
        System.out.println(canAttendAllAppointments(intervals));
    }

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1].end >= intervals[i].start) {
                return false;
            }
        }
        return true;
    }

}
