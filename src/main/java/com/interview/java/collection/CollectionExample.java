package com.interview.java.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionExample {
    //List
    private List<String> al = new ArrayList<>();
    @SuppressWarnings("unused")
    private List<String> ll = new LinkedList<>();
    @SuppressWarnings("unused")
    private List<String> vector = new Vector<>();
    @SuppressWarnings("unused")
    private List<String> stack = new Stack<>();


    //Set
    @SuppressWarnings("unused")
    private Set<String> hs = new HashSet<>();
    @SuppressWarnings("unused")
    private Set<String> lhs = new LinkedHashSet<>();
    @SuppressWarnings("unused")
    private Set<String> ts = new TreeSet<>();

    //Map
    private Map<String, String> map = new HashMap<>();
    @SuppressWarnings("unused")
    private Map<String, String> linkedMap = new LinkedHashMap<>();
    @SuppressWarnings("unused")
    private Map<String, String> treeMap = new TreeMap<>();


    //Thread safe versions of collections
    @SuppressWarnings({ "rawtypes", "unused" })
    private List syncList = Collections.synchronizedList(al);
    @SuppressWarnings("unused")
    private Map<String, String> syncMap = Collections.synchronizedMap(map);
    @SuppressWarnings("unused")
    private Map<String, String> concurrentMap = new ConcurrentHashMap<>();
}
