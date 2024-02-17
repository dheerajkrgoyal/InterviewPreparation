package com.interview.java.java8;

import java.util.Arrays;
import java.util.List;

public class MapReduceDemo {

    static class Employee{
        int id;
        String name;
        String grade;
        long salary;

        public Employee(int id, String name, String grade, long salary) {
            this.id = id;
            this.name = name;
            this.grade = grade;
            this.salary = salary;
        }
    }
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7};
        Integer sum = Arrays.stream(arr).boxed().reduce(0, (a, b) -> a+b);
        System.out.println("sum: " + sum);

        Integer max = Arrays.stream(arr).boxed().reduce(Integer.MIN_VALUE, (a, b) -> a>b?a:b);
        System.out.println("max: " + max);

        List<Employee> listOfEmployee = List.of(
                new Employee(1, "dheeraj", "A", 342434),
                new Employee(2, "neha", "A", 4324343),
                new Employee(3,"ayush", "B", 4334332),
                new Employee(4, "runit", "A", 13421213),
                new Employee(5, "ganesh", "B", 4132421)
        );

        double avgSalaryOfGradeAEmployee = listOfEmployee.stream()
                .filter(e -> e.grade.equals("A"))
                .map(e -> e.salary)
                .mapToDouble(s -> s)
                .average().getAsDouble();

        System.out.println("Average salary of grade A employee: " + avgSalaryOfGradeAEmployee);




    }
}
