package com.interview.ds.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

public class PreviousAndNextElement {
    public static void main(String[] args) {
        int[] arr = {4,10,5,18,3,12,7};
        System.out.println("Previous smallest elements: " + Arrays.toString(previousSmallestElements(arr)));
        System.out.println("Next smallest elements: " + Arrays.toString(nextSmallestElement(arr)));
        System.out.println("Previous greatest elements: " + Arrays.toString(previousGreatestElement(arr)));
        System.out.println("Next greatest elements: " + Arrays.toString(nextGreatestElement(arr)));
    }

    static int[] previousSmallestElements(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            int curr = arr[i];
            while(!stack.isEmpty() && curr<stack.peek()){
                stack.pop();
            }
            result[i] = !stack.isEmpty()? stack.peek():-1;
            stack.push(curr);
        }
        return result;
    }

    static int[] nextSmallestElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i = arr.length-1; i>=0; i--){
            int curr = arr[i];
            while(!stack.isEmpty() && curr<stack.peek()){
                stack.pop();
            }

            result[i] = !stack.isEmpty()? stack.peek():arr.length;
            stack.push(curr);
        }
        return result;
    }

    static int[] previousGreatestElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            int curr = arr[i];
            while(!stack.isEmpty() && curr>stack.peek()){
                stack.pop();
            }

            result[i] = !stack.isEmpty()?stack.peek():-1;
            stack.push(curr);
        }
        return result;
    }

    static int[] nextGreatestElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i = arr.length-1; i>=0; i--){
            int curr = arr[i];
            while(!stack.isEmpty() && curr>stack.peek()){
                stack.pop();
            }

            result[i] = !stack.isEmpty()? stack.peek():arr.length;
            stack.push(curr);
        }
        return result;
    }
}


