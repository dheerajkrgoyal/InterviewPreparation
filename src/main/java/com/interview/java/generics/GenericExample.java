package com.interview.java.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {
    public static void main(String[] args) {

        //We can store heterogeneous objects in collection
        //List list = new ArrayList();
        List<String> list = new ArrayList<>(); //Generic makes collection type safe
        list.add("a");
        list.add(String.valueOf(1));
        list.stream().map(o -> (String) o).forEach(System.out::println); //will throw class cast exception

        //String s = list.get(0); // Typecasting is required
        String s = (String) list.get(0);

        //using generics we make collection type safe
    }
}
