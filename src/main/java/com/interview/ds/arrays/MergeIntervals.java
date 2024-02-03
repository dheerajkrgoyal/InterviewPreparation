package com.interview.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{1,2},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    private static int[][] merge(int[][] intervals){
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int[] interval : intervals) {
            if (res.size() == 0 || res.get(res.size() - 1)[1] < interval[0]) {
                res.add(interval);
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], interval[1]);
            }
        }
        return res.toArray(new int[0][]);
    }
}
