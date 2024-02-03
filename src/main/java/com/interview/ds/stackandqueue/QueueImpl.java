package com.interview.ds.stackandqueue;

public class QueueImpl {

    static class CustomQueue{
        protected int[] data;
        private int end;
        private static int DEFAULT_SIZE = 10;

        public CustomQueue(){
            this(DEFAULT_SIZE);
        }
        public CustomQueue(int size){
            this.data = new int[size];
            this.end = -1;
        }

        public boolean isEmpty(){
            return end == -1;
        }

        public boolean isFull(){
            return end == data.length-1;
        }

        public boolean offer(int item){
            if(isFull()){
                System.out.println("Queue is full");
                return false;
            }
            data[++end] = item;
            return true;
        }

        public int poll(){
            if(isEmpty()){
              System.out.println("Queue is empty");
              return Integer.MIN_VALUE;
            }
            int removed = data[0];
            for(int i = 1; i<=end; i++){
                data[i-1] = data[i];
            }
            end--;
            return removed;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            return data[0];
        }

        public void display(){
            if(isEmpty()){
                System.out.println("Queue is empty");
            }
            for(int i = 0; i<=end; i++){
                System.out.print(data[i] + " <- ");
            }
            System.out.println("end");
        }
    }

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        queue.offer(1);
        queue.offer(2);
        queue.display();
        System.out.println(queue.poll());
        queue.display();
    }
}
