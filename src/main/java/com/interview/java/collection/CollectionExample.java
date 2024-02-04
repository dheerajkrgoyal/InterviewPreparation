package com.interview.java.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionExample {
    //List
    private List<String> al = new ArrayList<>();
    private List<String> ll = new LinkedList<>();
    private List<String> vector = new Vector<>();
    private List<String> stack = new Stack<>();


    //Set
    private Set<String> hs = new HashSet<>();
    private Set<String> lhs = new LinkedHashSet<>();
    private Set<String> ts = new TreeSet<>();

    //Map
    private Map<String, String> map = new HashMap<>();
    private Map<String, String> linkedMap = new LinkedHashMap<>();
    private Map<String, String> treeMap = new TreeMap<>();


    //Thread safe versions of collections
    private List syncList = Collections.synchronizedList(al);
    private Map<String, String> syncMap = Collections.synchronizedMap(map);
    private Map<String, String> concurrentMap = new ConcurrentHashMap<>();
}
