package com.interview.java.java8;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UseJava8FunctionInterface {
    public static void main(String[] args) {

        System.out.println("consumer demo");
        Consumer<Integer> consumer = (a)-> System.out.println(a);
        consumer.accept(2);
        List<Integer> list = List.of(1, 2, 3,4,5);
        System.out.println("example consumer in foreach printing list: ");
        list.stream().forEach(consumer);
        System.out.println("printing list: ");
        list.stream().forEach((a) -> System.out.println(a));

        System.out.println("predicate demo");
        Predicate<Integer> predicate = (a) -> a%2==0;
        System.out.println(predicate.test(2));
        System.out.println("example filter using predicate to filter and then consumer to print the list: ");
        list.stream().filter(predicate).forEach(consumer);

        System.out.println("supplier demo");
        Supplier<Integer> supplier = () -> 2;
        System.out.println(supplier.get());
        System.out.println("orElseGet accpets supplier functional interface");
        List<String> list1  = List.of();
        Supplier<String> supplier1 = () -> "I am empty list";
        System.out.println(list1.stream().findAny().orElseGet(supplier1));
    }
}
