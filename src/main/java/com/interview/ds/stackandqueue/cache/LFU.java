package com.interview.ds.stackandqueue.cache;

import java.util.HashMap;
import java.util.Map;

public class LFU {
    class Node{
        int key;
        int val;
        int frequency;
        Node next;
        Node prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    class DLL{
        Node head;
        Node tail;

        int listSize;

        public DLL(){
            this.head = new Node(0,0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            this.listSize = 0;
        }

        public void removeNode(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            this.listSize-- ;
        }

        public void addNode(Node node){
            Node headNext = head.next;
            head.next = node;
            node.prev = head;
            node.next = headNext;
            headNext.prev = node;
            this.listSize++;
        }
    }

    int maxCapacity;
    int currSize;
    int minFrequency;
    Map<Integer, DLL> frequencyMap;
    Map<Integer, Node> cache;

    public LFU(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.currSize = 0;
        this.minFrequency = 0;
        frequencyMap = new HashMap<>();
        cache = new HashMap<>();
    }

    public void updateNode(Node node){
        DLL currList = frequencyMap.get(node.frequency);
        currList.removeNode(node);

        if(node.frequency == minFrequency && currList.listSize == 0){
            minFrequency++;
        }
        ++node.frequency;
        DLL newList = frequencyMap.getOrDefault(node.frequency, new DLL());
        newList.addNode(node);
        frequencyMap.put(node.frequency, newList);
    }

    public int get(int key){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            updateNode(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int val){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = val;
            updateNode(node);
        }
        else{
            currSize++;
            if(currSize > maxCapacity){
                //remove least frequent node from cache
                DLL leastFrequentList = frequencyMap.get(minFrequency);
                cache.remove(leastFrequentList.tail.prev.key);
                leastFrequentList.removeNode(leastFrequentList.tail.prev);
                currSize--;
            }
            //add the new node
            minFrequency = 1;
            Node node = new Node(key, val);
            DLL currList = frequencyMap.getOrDefault(1, new DLL());
            currList.addNode(node);
            frequencyMap.put(1, currList);
            cache.put(key, node);
        }
    }
}
