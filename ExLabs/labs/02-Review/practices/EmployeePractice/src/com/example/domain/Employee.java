package com.example.domain;

public class Employee {

    private int empId;
    private String name;
    private String ssn;
    private double salary;
    private double increase;

    public Employee (int empId , String name , String ssn ,double salary){
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    public void raiseSalary(double increase) {
        salary += increase;
    }
    public int getEmpId() {
        return empId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSsn() {
        return ssn;
    }
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", ssn='" + ssn + '\'' +
                ", salary=" + salary +
                '}';
    }
}
