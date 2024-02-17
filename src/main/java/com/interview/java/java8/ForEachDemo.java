package com.interview.java.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachDemo {
    public static void main(String[] args) {
        System.out.println("forEach demo");
        List<String> listOfString = new ArrayList<>();
        listOfString.add("hello");
        listOfString.add("i");
        listOfString.add("am");
        listOfString.add("dheeraj");
        listOfString.add("goyal");


        listOfString.stream().forEach(s -> System.out.println(s));
        System.out.println("or we can use method reference directly");
        listOfString.stream().forEach(System.out::println);
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);

        map.forEach((key, value) -> System.out.println("Entry of the map " + key + ":" + value));
        System.out.println("we can use entry set in a map");
        map.entrySet().stream().forEach(obj -> System.out.println("Entry of the map " + obj.getKey() + ":" + obj.getValue()));

    }
}
