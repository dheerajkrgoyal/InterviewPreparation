package com.interview.java.inheritance;

public abstract class AbstractClass {
    @SuppressWarnings("unused")
    private int abstractInstanceVariable = 10;

    public void method(){
        System.out.println("abstract class method");
    }

    public abstract void abstractMethod();
}
