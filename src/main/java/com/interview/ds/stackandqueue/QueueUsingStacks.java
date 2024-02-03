package com.interview.ds.stackandqueue;

import java.util.Stack;

public class QueueUsingStacks {
    static class Queue{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean offer(int item){
            s1.push(item);
            return true;
        }

        public int pop(){
            if(s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public int peek(){
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }
    }
}
