package com.interview.ds.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

public class MaxAreaRectangleHistogram {

    public static void main(String[] args) {
        int[] arr = {1,1};
        System.out.println("Max area rectangle: " + maxAreaRectangle(arr));
    }

    static int maxAreaRectangle(int[] arr){
        int[] previousSmallest = findPreviousSmallest(arr);
        int[] nextSmallest = findNextSmallest(arr);
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            int area = (nextSmallest[i] - previousSmallest[i] - 1) * arr[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    static int[] findPreviousSmallest(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            int curr = arr[i];
            while(!stack.isEmpty() && curr<=arr[stack.peek()]){
                stack.pop();
            }
            result[i] = !stack.isEmpty()?stack.peek():-1;
            stack.push(i);
        }
        return result;
    }

    static int[] findNextSmallest(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i = arr.length-1; i>=0; i--){
            int curr = arr[i];
            while(!stack.isEmpty() && curr<=arr[stack.peek()]){
                stack.pop();
            }
            result[i] = !stack.isEmpty()?stack.peek():arr.length;
            stack.push(i);
        }
        return result;
    }
}
