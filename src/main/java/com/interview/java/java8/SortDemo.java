package com.interview.java.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class SortDemo {
    static class Employee{
        int id;
        String name;

        public Employee(int id, String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id && Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        List<Integer> list = List.of(4,2,9,8,5,6);
        System.out.println("list: " + list);

        list = list.stream().sorted()
                .collect(Collectors.toList());
        System.out.println("sorted list: " + list);

        list = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("reverse sorted: " + list);

        List<Employee> listOfEmployee = List.of(new Employee(1, "dheeraj"),
                new Employee(5, "neha"),
                new Employee(2, "runit"),
                new Employee(4, "ganesh"),
                new Employee(8, "ayush"));

        listOfEmployee = listOfEmployee.stream()
                .sorted((a, b) -> a.id - b.id)
                .collect(Collectors.toList());

        System.out.println("sorted list of employee: " + listOfEmployee);

        listOfEmployee = listOfEmployee.stream()
                .sorted(Comparator.comparing(a->a.name))
                .collect(Collectors.toList());
        System.out.println(listOfEmployee);

        Map<String, Integer> map = Map.of("dheeraj", 1,
                "ayush", 5,
                "neha", 3,
                "runit", 2);

        map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(System.out::println);

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        Map<Employee, Integer> mapOfObject = Map.of(new Employee(1, "dheeraj"), 1,
                new Employee(5, "neha"), 5,
                new Employee(2, "runit"), 2,
                new Employee(4, "ganesh"), 4,
                new Employee(8, "ayush"), 8);

        mapOfObject.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().name))
                .forEach(System.out::println);
    }
}
