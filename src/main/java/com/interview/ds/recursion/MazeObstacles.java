package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class MazeObstacles {

    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        System.out.println(ways(maze, 0, 0,""));
    }

    static List<String> ways(boolean[][] maze, int r, int c, String ans){
        List<String> result = new ArrayList<>();
        if(r == maze.length-1 && c == maze[0].length-1){
            result.add(ans);
            return result;
        }
        if(!maze[r][c]){//we hit the obstacle, so it can't be possible ans so we just return
            return result;
        }
        if(r< maze.length-1)
            result.addAll(ways(maze, r+1, c, ans + "D")); //down
        if(c<maze[0].length-1)
            result.addAll(ways(maze, r, c+1, ans + "R")); //right

        return result;
    }
}
