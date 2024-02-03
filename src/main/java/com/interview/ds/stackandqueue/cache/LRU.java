package com.interview.ds.stackandqueue.cache;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static class Node {
        public int key;
        public int val;
        public Node next;
        public Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRU(int capacity){
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<>();
    }

    public void addNode(Node node){
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    public void removeNode(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int val){
        Node node = new Node(key, val);
        if(map.containsKey(key)){
            removeNode(map.get(key));
        }
        if(map.size() == capacity){
            removeNode(tail.prev);
        }
        addNode(node);
    }
}
