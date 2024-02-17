package com.interview.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallelStreamDemo {

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
        long startTime = 0;
        long endTime = 0;

        startTime = System.currentTimeMillis();
        IntStream.range(1, 1000).forEach(i -> System.out.print(i + " "));
        endTime = System.currentTimeMillis();

        long  sequentialTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        IntStream.range(1, 1000).parallel().forEach(i -> System.out.print(i + " "));
        endTime = System.currentTimeMillis();

        System.out.println("\n\nSequential stream time taken: " + sequentialTime);
        System.out.println("Parallel stream time taken: " + (endTime-startTime));

        List<Employee> employeeList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i<1000; i++){
            employeeList.add(new Employee(i, "employee" + i, "A", random.nextLong(1000*1000)));
        }

        startTime = System.currentTimeMillis();
        double averageSalary = employeeList.stream()
                .filter(e -> e.grade.equals("A"))
                .map(e -> e.salary)
                .mapToDouble(s->s)
                .average().getAsDouble();
        endTime = System.currentTimeMillis();

        sequentialTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        double averageSalaryParallel = employeeList.stream().parallel()
                .filter(e -> e.grade.equals("A"))
                .map(e -> e.salary)
                .mapToDouble(s->s)
                .average().getAsDouble();
        endTime = System.currentTimeMillis();

        System.out.println("Sequential time taken: " + sequentialTime + " average salary: " + averageSalary);
        System.out.println("Parallel time taken: " + (endTime-startTime) + " average salary: " + averageSalaryParallel);



    }
}
