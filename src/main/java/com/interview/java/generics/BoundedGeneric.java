package com.interview.java.generics;

public class BoundedGeneric {

    //T extends class or interface
    //<T extends Number & Runnable> //allowed class & interface
    //<T extends Runnable & Number> // not allowed interface & class
    //<T extends Number & Thread> //not allowed class & class
    static class Op<T extends Number>{
        T a;
        T b;
        public Op(T a, T b){
            this.a = a;
            this.b = b;
        }

        public void operation(){
            System.out.println(a.intValue() + b.intValue());
        }
    }

    public static void main(String[] args) {
        Op<Integer> ob = new Op<>(5,2);
        //Op<String> ob1 = new Op<>("a", "b"); //compile time error
        ob.operation();
    }
}
