package com.interview.java.inheritance;

public class SuperClass {
    private String instanceSuper = "instance variable super class";
    private String staticSuper = "static variable super class";

    static{
        System.out.println("static block super class");
    }

    {
        System.out.println("initialization block super class");
    }
    public SuperClass(){
        System.out.println("super class constructor");
        method();
    }

    public void method(){
        System.out.println("This is super class method");
    }
}
