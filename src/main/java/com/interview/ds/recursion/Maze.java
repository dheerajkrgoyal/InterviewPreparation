package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    public static void main(String[] args) {
        System.out.println(maze(3, 0, 0, ""));
    }

    //can go only right, down
    private static List<String> maze(int n, int r, int c, String ans){
        List<String> result = new ArrayList<>();
        if(r >= n || c>=n){//if crossed the maze size, it cannot be ans, so just return
            return result;
        }
        if(r == n-1 && c == n-1){
            result.add(ans);
            return result;
        }

        result.addAll(maze(n, r+1, c, ans+"D")); //down
        result.addAll(maze(n, r, c+1, ans+"R")); //right
        return result;
    }


    @SuppressWarnings("unused")
    private static List<String> maze2(int n, int r, int c, String ans){
        List<String> result = new ArrayList<>();
        if(r == n-1 && c == n-1){  //reached last cell
            result.add(ans);
            return result;
        }
        if(r<n-1) //already reached last row, cant go further down
            result.addAll(maze(n, r+1, c, ans+"D")); //down
        if(c<n-1) //already reached last column, cant go further right
            result.addAll(maze(n, r, c+1, ans+"R")); //right
        return result;
    }
}
