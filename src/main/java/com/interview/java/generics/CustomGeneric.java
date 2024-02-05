package com.interview.java.generics;

public class CustomGeneric {

    static class Gen<T>{
        T ob;
        public Gen(T ob){
            this.ob = ob;
        }

        public void show(){
            System.out.println("Type of ob is: " + ob.getClass().getName());
        }

        public T getOb(){
            return ob;
        }
    }

    public static void main(String[] args) {
        Gen<String> gen = new Gen<>("ab");
        gen.show();
        System.out.println(gen.getOb());

        Gen<Double> gen1 = new Gen<>(34.5);
        gen1.show();
        System.out.println(gen1.getOb());
    }
}
