package com.interview.java;

/**
 * 1. First initialization value is assigned to both static and instance variable which is there in declaration
 * 2. Since class is loaded first to create its object, Class's static block is called
 * 3. Object initialization block is called
 * 4. Constructor is called
 * 5. At last main() rest of the statement is executed.
 */
public class ObjectInitializationOrder {

    @SuppressWarnings("unused")
    private static String staticVariable= "static variable";
    @SuppressWarnings("unused")
    private String instanceVariable = "instance variable";
    int[] arr = new int[5];

    static {
        System.out.println("Hi I am static block");
    }

    {
        System.out.println("Hi I am initialization block");
    }

    public ObjectInitializationOrder(){
        System.out.println("Hi I am constructor");
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        ObjectInitializationOrder object = new ObjectInitializationOrder();
        System.out.println("Hi I am main function");
    }
}
