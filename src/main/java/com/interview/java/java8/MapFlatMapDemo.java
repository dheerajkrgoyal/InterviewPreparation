package com.interview.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapFlatMapDemo {

    static class Customer{
        int id;
        String name;
        String email;
        List<String> phoneNumbers;

        public Customer(int id, String name, String email, List<String> phoneNumbers){
            this.id = id;
            this.name = name;
            this.email = email;
            this.phoneNumbers = phoneNumbers;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", phoneNumbers=" + phoneNumbers +
                    '}';
        }
    }
    public static void main(String[] args) {
        List<Customer> customerList = List.of(
                new Customer(4, "dheeraj", "dheeraj@gmail.com", Arrays.asList("4234343", "22414325")),
                new Customer(2, "neha", "neha@gmail.com", Arrays.asList("42543545", "8454758478")),
                new Customer(7, "runit", "runit@gmail.com", Arrays.asList("35748547", "783278393")),
                new Customer(1, "ayush", "ayush@gmail.com", Arrays.asList("375837583","32457837"))
        );

        //create list of emails
        List<String> listOfEmails = customerList.stream()
                .map(c -> c.email)
                .collect(Collectors.toList());
        System.out.println("list of emails: " + listOfEmails);

        //create list of phone nos
        List<String> listOfPhone = customerList.stream()
                .flatMap(c -> c.phoneNumbers.stream())
                .collect(Collectors.toList());

        System.out.println("list of phone: " + listOfPhone);
    }
}
