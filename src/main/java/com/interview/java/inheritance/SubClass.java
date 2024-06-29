package com.interview.java.inheritance;

/**
 * Order of execution
 * 1. static block super class
 * 2. static block sub class
 * 3. initialization block super class
 * 4. super class constructor
 * 5. initialization block sub class
 * 6. sub class constructor
 *
 * NOTE: If a method is overriden in subclass and the method is being used in super class constructor
 * while calling method, super class will invoke subclass's overriden method
 */
public class SubClass extends SuperClass{
    @SuppressWarnings("unused")
    private String instanceSub = "instance variable sub class";
    @SuppressWarnings("unused")
    private String staticSub = "static variable sub class";

    static{
        System.out.println("static block sub class");
    }

    {
        System.out.println("initialization block sub class");
    }

    public SubClass(){
        System.out.println("sub class constructor");
    }

    @Override
    public void method(){
        System.out.println("This is overriden subclass class method called from super class constructor");
    }


    public static void main(String[] args) {
        @SuppressWarnings("unused")
        SubClass obj = new SubClass();
    }
}
