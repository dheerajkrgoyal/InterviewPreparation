package com.interview.java.generics;

import java.util.List;

public class GenericMethod {

    //read-only methods
    public static void method(List<?> list){
        System.out.println("My method: " + list);
        //list.add(3) //not valid
    }

    public static void method1(@SuppressWarnings("rawtypes") List<? extends Comparable> list){
        System.out.println("My method1: " + list);
    }

    public static <T> void myMethod(List<T> ob){
        System.out.println(ob);
    }

    public static void main(String[] args) {
        method(List.of(1, 2, 3, 4));
        method1(List.of(1, 2, 3, 4, 5));
        myMethod(List.of(1, 2, 3, 4, 5, 6));
    }
}
