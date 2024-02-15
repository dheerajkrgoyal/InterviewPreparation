package com.interview.java.java8;

public class MyFunctionalInterfaceMain {
    public static void main(String[] args) {

        MyFunctionalInterface fi = (a,b) -> {
            int sum = a+b;
            System.out.println("This is test function for sum " + sum);
        };
        MyFunctionalInterface noBrace = (a, b)-> System.out.println("Don't need brace for single statement " + a+b );

        fi.test(1, 2);
        noBrace.test(2, 4);
    }
}
