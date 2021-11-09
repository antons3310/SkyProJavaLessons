package ru.ashebalkin.skypro.coursework01;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    public int employeeId;                          //Идентификатор
    private final String firstName;                 //Имя
    private final String lastName;                  //Фамилия
    private final String middleName;                //Отчество
    private int departmentId;                       //подразделение
    private double salaryAmount;                     //Зарплата
    private static int employeeCount = 0;           //Счетчик
    private static final List employeesList = new ArrayList();

    public Employee(String lastName, String firstName, String middleName, int departmentId, double salaryAmount, int employeeId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.departmentId = departmentId;
        this.salaryAmount = salaryAmount;
        this.employeeId = Employee.employeeCount + 1;
        employeeCount = Employee.employeeCount + 1;
        employeesList.add(this);
    }

    public Employee(String lastName, String firstName, String middleName, int departmentId, double salaryAmount) {
        this(lastName, firstName, middleName, departmentId, salaryAmount, 0);
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public double getSalaryAmount() {
        return salaryAmount;
    }

    public static List getEmployeesList(){
        return employeesList;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setSalaryAmount(double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    @Override
    public String toString() {
        return "Идентификатор сотрудника - " + employeeId
                    + ", ФИО - " + lastName + ' ' + firstName + ' ' + middleName
                    + ", Подразделение - " +  departmentId
                    + ", Зарплата - " + salaryAmount;
    }
}
