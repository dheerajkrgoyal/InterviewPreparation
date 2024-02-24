package com.interview.designguru.patterns.mergeintervals;

import java.util.*;

/**
 * We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
 * Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
 *
 * Jobs: [[1,4,3], [2,5,4], [7,9,6]]
 * Output: 7
 * Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
 * jobs are running at the same time i.e., during the time interval (2,4).
 *
 * Jobs: [[1,4,2], [2,4,1], [3,6,5]]
 * Output: 8
 * Explanation: Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4].
 *
 */
public class MaximumCPULoad {

    static class Job{
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad){
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>(Arrays.asList(
                new Job(1,4,3),
                new Job(2, 5, 4),
                new Job(7,9,6)));

        System.out.println(findMaxCPULoad(jobs));
    }

    public static int findMaxCPULoad(List<Job> jobs) {
        int maxCPULoad = 0;
        //will keep track of current load on cpu
        int currentCPULoad = 0;
        //sort the job based on start time
        jobs.sort((a, b) -> a.start - b.start);
        //will keep track of jobs which are currently loaded in cpu
        PriorityQueue<Job> loadedJobs = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        for(int i = 0; i<jobs.size(); i++){
            //before adding any new job we will remove job which has been completed
            while(!loadedJobs.isEmpty() && loadedJobs.peek().end<=jobs.get(i).start){
                Job jobEnded = loadedJobs.poll();
                //simultaneously decrease cpu load as well
                currentCPULoad-=jobEnded.cpuLoad;
            }
            //add new job and its load
            loadedJobs.offer(jobs.get(i));
            currentCPULoad+=jobs.get(i).cpuLoad;
            //at each point keep track of what is max load
            maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
        }

        return maxCPULoad;
    }
}
