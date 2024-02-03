package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPathBacktracking {
    public static void main(String[] args) {
        boolean[][] maze ={
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        System.out.println(allPath(maze, 0, 0, ""));
    }

    static List<String> allPath(boolean[][] maze, int r, int c, String ans){
        List<String> result = new ArrayList<>();
        if(r == maze.length-1 && c == maze[0].length-1){
            result.add(ans);
            return result;
        }

        if(!maze[r][c]){
            return result;
        }

        maze[r][c] = false;

        if(r<maze.length-1){
            result.addAll(allPath(maze, r+1, c, ans + "D"));
        }

        if(c<maze[0].length-1){
            result.addAll(allPath(maze, r, c+1, ans + "R"));
        }

        if(r>0){
            result.addAll(allPath(maze, r-1, c, ans + "U"));
        }

        if(c>0){
            result.addAll(allPath(maze, r, c-1, ans + "L"));
        }

        maze[r][c] = true;
        return result;
    }
}
