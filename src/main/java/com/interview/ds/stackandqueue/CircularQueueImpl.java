package com.interview.ds.stackandqueue;

public class CircularQueueImpl {

    static class CircularQueue{
        protected int[] data;
        protected int front;
        protected int end;

        protected int size;

        public CircularQueue(int size){
            this.data = new int[size];
            this.front = -1;
            this.end = -1;
            this.size = size;
        }

        public CircularQueue(){
            this(10);
        }

        public boolean isEmpty(){
            return front == -1;
        }

        public boolean isFull(){
            return (end+1)%size == front;
        }

        public boolean offer(int item){
            if(isFull()){
                System.out.println("Queue is full");
                return false;
            }
            if(isEmpty()){
                front++;
            }
            end = ++end % size;
            data[end] = item;
            return true;
        }

        public int poll(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            int removed = data[front];
            if(front == end){
                front = end = -1;
                return removed;
            }
            front = ++front%size;
            return removed;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }

            return data[front];
        }

        public void display(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("front: " + front + " end: " + end);
            int i = front;
            while(true){
                if(i==end){
                    System.out.print(data[i] + " <- ");
                    break;
                }
                System.out.print(data[i] + " <- ");
                i = (i +1) % size;
            }
            System.out.println("end");
        }
    }

    static class DynamicCircularQueue extends CircularQueue{
        public DynamicCircularQueue(int size){
            super(size);
        }

        @Override
        public boolean offer(int item){
            if(isFull()){
                int[] temp = new int[size *2];
                for(int i = 0; i<size; i++){
                    temp[i] = data[(i+front) % size];
                }
                data = temp;
                front = 0;
                end = size-1;
                size = size *2;
            }
            return super.offer(item);
        }
    }


    public static void main(String[] args) {
        DynamicCircularQueue queue = new DynamicCircularQueue(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.display();
        queue.poll();
        queue.poll();
        queue.display();
        queue.offer(4);
        queue.display();
        queue.poll();
        queue.display();
        queue.poll();
        queue.display();
        queue.poll();
        queue.display();
        queue.poll();
        queue.offer(10);
        queue.display();
        queue.poll();
        queue.display();
    }
}
