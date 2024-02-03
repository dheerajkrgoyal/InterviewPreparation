package com.interview.ds.stackandqueue;


public class StackImpl {

    static class CustomStack{
        protected int[] data;
        private int top;
        private static final int DEFAULT_SIZE = 10;

        public CustomStack(){
            this(DEFAULT_SIZE);
        }
        public CustomStack(int size){
            this.data = new int[size];
            this.top = -1;
        }

        public boolean isEmpty(){
            return top==-1;
        }

        public boolean isFull(){
            return top == data.length-1;
        }

        public boolean push(int item){
            if(isFull()){
                System.out.println("Stack is full");
                return false;
            }
            data[++top] = item;
            return true;
        }

        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }
            return data[top--];
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }
            return data[top];
        }
    }

    static class DynamicStack extends CustomStack{
        public DynamicStack(){
            super();
        }

        public DynamicStack(int size){
            super(size);
        }

        @Override
        public boolean push(int item){
            if(isFull()){
                //double the array size
                int[] temp = new int[data.length * 2];
                for(int i = 0; i<data.length; i++){
                    temp[i] = data[i];
                }
                data = temp;
            }
            return super.push(item);
        }
    }


    public static void main(String[] args) {
        System.out.println("Custom stack");
        CustomStack stack = new CustomStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("Dynamic Stack");
        DynamicStack ds = new DynamicStack(5);
        ds.push(1);
        ds.push(2);
        ds.push(3);
        ds.push(4);
        ds.push(5);
        ds.push(6);
        System.out.println(ds.peek());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
    }
}
