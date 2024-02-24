package com.interview.designguru.patterns.mergeintervals;

import java.util.*;

/**
 * For ‘K’ employees, we are given a list of intervals representing each employee’s working hours.
 * Our goal is to determine if there is a free interval which is common to all employees.
 * You can assume that each list of employee working hours is sorted on the start time.
 *
 * Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
 * Output: [3,5]
 * Explanation: All the employees are free between [3,5].
 *
 * Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
 * Output: [4,6], [8,9]
 * Explanation: All employees are free between [4,6] and [8,9].
 *
 * Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
 * Output: [5,7]
 * Explanation: All employees are free between [5,7].
 */
public class CalculateEmployeeFreeTime {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString(){
            return "[" + start + "," + end + "]";
        }
    }

    public static void main(String[] args) {

        List<List<Interval>> schedule = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(new Interval(1,3), new Interval(9,12))),
                new ArrayList<>(Arrays.asList(new Interval(2,4), new Interval(6,8)))
        ));

        System.out.println(findEmployeeFreeTime(schedule));
    }

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        List<Interval> flattenList = new ArrayList<>();
        //flatten list
        for(List<Interval> s : schedule){
            for(Interval i: s){
                flattenList.add(i);
            }
        }
        //sort the list based on start time
        flattenList.sort(Comparator.comparingInt(a -> a.start));

        //merge all overlapping-intervals
        LinkedList<Interval> mergedIntervals = new LinkedList<>();
        for(int i = 0; i<flattenList.size(); i++){
            if(mergedIntervals.size() == 0 || mergedIntervals.getLast().end< flattenList.get(i).start){
                mergedIntervals.add(flattenList.get(i));
            }
            else{
                mergedIntervals.getLast().end = Math.max(mergedIntervals.getLast().end, flattenList.get(i).end);
            }
        }

        //find non-overlapping time in merged intervals
        for(int i = 0; i<mergedIntervals.size()-1; i++){
            result.add(new Interval(mergedIntervals.get(i).end, mergedIntervals.get(i+1).start));
        }

        return result;
    }
}
