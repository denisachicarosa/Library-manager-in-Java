package com.persons.tema1;

import com.fmi.tema1.Date;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Employee extends Person {
    private String function;
    private Double salary;


    @Override
    public void readData() {
        super.readData();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("function : ");
            function = reader.readLine();
            System.out.println("salary ");
            Scanner in = new Scanner(System.in);
            salary = in.nextDouble();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  void printData() {
        super.printData();
        System.out.println("function : " + function);
        System.out.println("salary : " + salary);
    }
    public Employee() {
        function = "";
        salary = 0.0;
    }

    public Employee(String function, Double salary) {
        this.function = function;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName, String birthday, String adress, String function, Double salary) {
        super(firstName, lastName, birthday, adress);
        this.function = function;
        this.salary = salary;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
