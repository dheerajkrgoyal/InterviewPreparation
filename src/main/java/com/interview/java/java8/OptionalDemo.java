package com.interview.java.java8;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        Optional emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        Optional container = Optional.ofNullable(null);
        System.out.println(container);
        container.ifPresentOrElse(System.out::println, () -> System.out.println("I am null"));

        Optional<String> containerOfString = Optional.of("stringObject");
        System.out.println(containerOfString);
        System.out.println(containerOfString.get());
        System.out.println(containerOfString.map(String::toUpperCase).orElse("DEFAULT"));

    }
}
