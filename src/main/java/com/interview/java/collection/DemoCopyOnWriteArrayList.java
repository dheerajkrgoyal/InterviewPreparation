package com.interview.java.collection;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArraylist allows concurrent modification
 * however simultaneous reading thread wont see the changes immediately.
 * iterator's remove function won't work in case of this class
 */
public class DemoCopyOnWriteArrayList extends Thread{
    private static List<Integer> list = new CopyOnWriteArrayList<>();

    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("updating by child thread");
        list.add(3);
    }


    public static void main(String[] args) throws InterruptedException {
        list.add(1);
        list.add(2);
        DemoCopyOnWriteArrayList thread = new DemoCopyOnWriteArrayList();
        thread.start();
        Iterator<Integer> iterator = list.iterator();
        System.out.println("iterating by main thread");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            Thread.sleep(3000);
        }

        iterator = list.iterator();
        System.out.println("iterating again by main thread");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            Thread.sleep(3000);
        }

        //Trying to remove now
        iterator = list.iterator();
        System.out.println("main thread trying to to remove element");
        while(iterator.hasNext()){
            Integer a = iterator.next();
            if(a.equals(1)){
                iterator.remove();
            }
        }
    }


}
