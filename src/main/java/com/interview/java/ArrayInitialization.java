package com.interview.java;

/**
 * Although at compile time it seems that array is the A[] reference which is super class, it can hold all the objects
 * But in actual it is referencing to the object of type B
 * B and C are peer class while A is parent class of A
 * therefore B won't be able to hold A and C object which is identified at RUNTIME.
 */
public class ArrayInitialization {

    static class A{}

    static class B extends A{}

    static class C extends A{}

    public static void main(String[] args) {
        A[] arr = new B[3];
        arr[0] = new B();
        arr[1] = new C();
        arr[2] = new A();
    }
}
