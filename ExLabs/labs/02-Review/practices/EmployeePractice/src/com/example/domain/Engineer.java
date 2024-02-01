package com.example.domain;

public class Engineer extends Employee{

    public Engineer(int empId , String name , String ssn ,double salary){
        super(empId,name,ssn,salary);
    }

    @Override
    public String toString() {
        return "Engineer{"+ super.toString() +"}";
    }
}
