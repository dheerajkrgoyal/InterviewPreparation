package com.interview.designguru.patterns.mergeintervals;

import java.util.*;

/**
 * Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum
 * number of rooms required to hold all the meetings.
 *
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings.
 * [7,9] can occur in any of the two rooms later.
 *
 * Meetings: [[1,4], [2,3], [3,6]]
 * Output:2
 * Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6],
 * we need two rooms to hold all the meetings.
 *
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * Output: 2
 * Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
 */
public class MinimumMeetingRoomsNeeded {
    static class Meeting{
        int start;
        int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<Meeting> meetings = new ArrayList<>(Arrays.asList(
                new Meeting(4,5),
                new Meeting(2,3),
                new Meeting(2,4),
                new Meeting(3,5)
        ));

        System.out.println(findMinimumMeetingRooms(meetings));
    }

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));
        int minRooms = 0;
        //holds active room in which meeting is taking place
        //it will be sorted based on ending time since the meeting completed early will remove first
        PriorityQueue<Meeting> rooms = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        //loop through each meeting
        for(int i=0; i<meetings.size(); i++){
            //if there are meeting which is ending early than the current meeting remove them
            while(!rooms.isEmpty() && rooms.peek().end<=meetings.get(i).start){
                rooms.poll();
            }
            //add current meeting
            rooms.offer(meetings.get(i));
            //track at any time how many active rooms are there
            minRooms = Math.max(minRooms, rooms.size());
        }
        return minRooms;
    }
}
