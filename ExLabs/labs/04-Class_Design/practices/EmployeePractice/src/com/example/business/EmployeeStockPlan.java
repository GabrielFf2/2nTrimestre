package com.example.business;

import com.example.domain.Director;
import com.example.domain.Employee;
import com.example.domain.Engineer;
import com.example.domain.Manager;

public class EmployeeStockPlan {
    int directorStock = 1000;
    int managerStock = 100;
    int EmployeesStock = 10;


    public int grantStock (Employee emp){

        if (emp instanceof Director ) return directorStock;
        if (emp instanceof Manager) return managerStock;
        return EmployeesStock;

    }
}
