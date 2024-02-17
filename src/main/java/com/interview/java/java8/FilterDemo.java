package com.interview.java.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterDemo {
    public static void main(String[] args) {

        System.out.println("filter demo");
        List<String> listOfString = new ArrayList<>();
        listOfString.add("hello");
        listOfString.add("i");
        listOfString.add("am");
        listOfString.add("dheeraj");
        listOfString.add("goyal");

        System.out.println("demo on list");
        listOfString.stream().filter(s -> s.length() == 5).forEach(System.out::println);


        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        System.out.println("demo on map");
        map.entrySet().stream().filter(obj -> obj.getValue()%2 == 0).forEach(System.out::println);

    }
}
