package com.interview.java.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * while using normal hashmap we won't be able to iterate and modify it using 2 threads,
 * it will throw ConcurrentModificationException
 * but using concurrent hash map we will be able to do so
 * however while thread which is iterating has no guarantee that new updation will be reflected there.
 * it may or may not
 */
public class DemoConcurrentModification extends Thread{
    //private static Map<Integer, String> map = new HashMap<>();
    private static Map<Integer, String> map = new ConcurrentHashMap<>();

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("child thread updating list");
        map.put(4, "d");
    }

    public static void main(String[] args) throws InterruptedException {
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        DemoConcurrentModification thread = new DemoConcurrentModification();
        thread.start();
        Iterator<Integer> iterator = map.keySet().iterator();
        System.out.println("main thread iterating list");
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            System.out.println(integer);
            Thread.sleep(3000);
        }
    }
}
