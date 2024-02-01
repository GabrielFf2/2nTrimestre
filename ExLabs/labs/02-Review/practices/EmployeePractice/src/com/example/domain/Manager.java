package com.example.domain;

public class Manager extends Employee{

    private String deptName;
    private Employee[] staff;
    private int employeeCount = 0;
    public Manager(int empId, String name, String ssn, double salary, String deptName) {
        super(empId, name, ssn, salary);
        this.deptName = deptName;
        // Construct an array of up to 20 employees
        this.staff = new Employee[20];
    }

    public String getDeptName() {
        return deptName;
    }
    public int findEmployee(Employee e) {
        int result = -1;
        for (int i = 0; i < employeeCount; i++)
            if (e.equals(staff[i])) result = i;
        return result;
    }
    public boolean addEmployee(Employee e) {
        if (findEmployee(e) != -1) return false;
        staff[employeeCount] = e;
        employeeCount++;
        return true;
    }
    public boolean removeEmployee(Employee e) {
        boolean empPartOfStaff = false;
        Employee[] newStaff = new Employee[20];
        int newEmpCount = 0;
        for (int i = 0; i < employeeCount; i++) {
            if (staff[i].getEmpId() == e.getEmpId()) {
                empPartOfStaff = true;
            } else {
                newStaff[newEmpCount] = staff[i];
                newEmpCount++;
            }
        }
        if (empPartOfStaff) {
            staff = newStaff;
            employeeCount = newEmpCount;
        }
        return empPartOfStaff;
    }
    public void printStaffDetails() {
        System.out.println ("Staff of " + this.getName() + ":");
        for (int i=0; i < employeeCount; i++) {
            System.out.println ("Name: " + staff[i].getName() + " Employee id: " + staff[i].getEmpId());
        }
    }
    @Override
    public String toString() {
        return "Manager{" +
                "deptName='" + deptName + '\'' + super.toString() +
                '}';
    }
}
