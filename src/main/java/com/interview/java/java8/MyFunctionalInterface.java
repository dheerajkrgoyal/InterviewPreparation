package com.interview.java.java8;


public interface MyFunctionalInterface {

    void test(int a, int b);

    default void print(){
        System.out.println("Hello I am functional interface");
    }
    public static void staticFunction(){
        System.out.println("This is static function");
    }
}
