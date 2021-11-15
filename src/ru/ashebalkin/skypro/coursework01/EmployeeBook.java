package ru.ashebalkin.skypro.coursework01;

import java.util.*;
import java.util.function.BinaryOperator;

public class EmployeeBook {
    private final Employee[] employees;

    public EmployeeBook() {
        this.employees = new Employee[11];
        fillEmployeeArray(this.employees);
    }

    public void addNewEmployee(String lastName, String firstName, String middleName, int departmentId, double salaryAmount) {
        Employee newEmp = new Employee(lastName, firstName, middleName, departmentId, salaryAmount);
        boolean noMoreSpace = false;
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i] == null) {
                this.employees[i] = newEmp;
                noMoreSpace = false;
                break;
            } else {
                noMoreSpace = true;
            }
        }
        if (noMoreSpace == true) {
            throw new NullPointerException("Нет свободных ячеек массива");
        }
    }

    public void deleteEmployeeFromBook(int id) {
        Employee e = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmployeeId() == id) {
                    e = employees[i];
                    employees[i] = null;
                    break;
                }
            }
        }
        if (e == null) {
            throw new NullPointerException("По переданному ИД сотрудника не найдно");
        }
    }

    public void deleteEmployeeFromBook(String lastName, String firstName, String middleName) {
        Employee e = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].equals(lastName, firstName, middleName)) {
                    e = employees[i];
                    employees[i] = null;
                    return;
                }
            }
        }
        if (e == null) {
            throw new NullPointerException("По переданным ФИО сотрудника не найдно");
        }
    }
//    }    public void deleteEmployeeFromBook(String lastName, String firstName, String middleName) {
//        Employee e = null;
//        for (int i = 0; i < employees.length; i++) {
//            if (employees[i] != null) {
//                if (employees[i].getLastName().toLowerCase().equals(lastName.toLowerCase()) &&
//                        employees[i].getFirstName().toLowerCase().equals(firstName.toLowerCase()) &&
//                        employees[i].getMiddleName().toLowerCase().equals(middleName.toLowerCase())) {
//                    e = employees[i];
//                    employees[i] = null;
//                    return;
//                }
//            }
//        }
//        if (e == null) {
//            throw new NullPointerException("По переданным ФИО сотрудника не найдно");
//        }
//    }

    public void updateEmployeeInfo(String lastName, String firstName, String middleName, double salary) {
        Employee e = null;

        checkSalaryChange(salary);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].equals(lastName, firstName, middleName) && employees[i] != null) {
                    employees[i].setSalaryAmount(salary);
                    return;
                }
            }
        }
        if (e == null) {
            throw new NullPointerException("По переданным ФИО сотрудника не найдно");
        }
    }

    public void updateEmployeeInfo(String lastName, String firstName, String middleName, int departmentId) {
        Employee e = null;

        if (departmentId < 1 || departmentId > 5) {
            throw new NullPointerException("Номера отделов в диапазоне от 1 до 5");
        }

        for (int i = 0; i < this.employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].equals(lastName, firstName, middleName) && employees[i] != null) {
                    employees[i].setDepartmentId(departmentId);
                    return;
                }
            }
        }
        if (e == null) {
            throw new NullPointerException("По переданным ФИО сотрудника не найдно");
        }
    }

    public void updateEmployeeInfo(String lastName, String firstName, String middleName, double salary, int departmentId) {
        Employee e = null;

        checkSalaryChange(salary);

        if (departmentId < 1 || departmentId > 5) {
            throw new NullPointerException("Номера отделов в диапазоне от 1 до 5");
        }

        for (int i = 0; i < this.employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].equals(lastName, firstName, middleName) && employees[i] != null) {
                    employees[i].setSalaryAmount(salary);
                    employees[i].setDepartmentId(departmentId);
                    return;
                }
            }
        }
        if (e == null) {
            throw new NullPointerException("По переданным ФИО сотрудника не найдно");
        }
    }

    public void printEmployeeByDepId() {

        List departmentList = new ArrayList();

        //сохраним все наши подразделения
        for (Employee emp : this.employees) {
            if (emp != null) {
                departmentList.add(emp.getDepartmentId());
            }
        }

        //очистим от дублей
        Set set = new HashSet<>(departmentList);
        departmentList.clear();
        departmentList.addAll(set);

        //забабахаем цикл и используем метод реализованные ранее
        for (int i = 0; i < departmentList.size(); i++) {
            printEmployeesInfo((int) departmentList.get(i));
        }
    }

    public void printEmployeeByDepIdAlt() {
        TreeMap<Integer, StringBuilder> map = new TreeMap<>();
        StringBuilder strDep1 = new StringBuilder();
        StringBuilder strDep2 = new StringBuilder();
        StringBuilder strDep3 = new StringBuilder();
        StringBuilder strDep4 = new StringBuilder();
        StringBuilder strDep5 = new StringBuilder();

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                switch (employees[i].getDepartmentId()) {
                    case 1:
                        strDep1.append(getEmployeeInfoById(employees, employees[i].getEmployeeId(), 2)).append("\n");
                        map.put(employees[i].getDepartmentId(), strDep1);
                        break;
                    case 2:
                        strDep2.append(getEmployeeInfoById(employees, employees[i].getEmployeeId(), 2)).append("\n");
                        map.put(employees[i].getDepartmentId(), strDep2);
                        break;
                    case 3:
                        strDep3.append(getEmployeeInfoById(employees, employees[i].getEmployeeId(), 2)).append("\n");
                        map.put(employees[i].getDepartmentId(), strDep3);
                        break;
                    case 4:
                        strDep4.append(getEmployeeInfoById(employees, employees[i].getEmployeeId(), 2)).append("\n");
                        map.put(employees[i].getDepartmentId(), strDep4);
                        break;
                    case 5:
                        strDep5.append(getEmployeeInfoById(employees, employees[i].getEmployeeId(), 2)).append("\n");
                        map.put(employees[i].getDepartmentId(), strDep5);
                        break;
                }
            } else continue;
        }

        for (Map.Entry e : map.entrySet()) {
            System.out.println("Список сотрудников отдела - " + e.getKey() + ":" + ("\n") + e.getValue());

        }

    }


    private void checkSalaryChange(double summ) {
        if (summ < 0) {
            throw new NullPointerException("Передана отрицательная сумма. Изменение не возможно");
        }
    }

    public void fillEmployeeArray(Employee[] employees) {
        for (int i = 0; i < Employee.getEmployeesList().size(); i++) {
            this.employees[i] = Employee.getEmployeesList().get(i);
        }
    }

    public List<Employee> fillEmployeeArrayList(Employee[] employees) {
        List<Employee> employeeList = new ArrayList<Employee>();
        for (int i = 0; i < Employee.getEmployeesList().size(); i++) {
            employeeList.add(this.employees[i]);
        }
        return employeeList;
    }

    //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString))
    public void getEmployeeInfo() {
        for (int i = 0; i < Employee.getEmployeeCount(); i++) {
            System.out.println(this.employees[i]);
        }
    }

    //Посчитать сумму затрат на зарплаты в месяц
    public double calcTotalSalaryPayment(Employee[] employees) {
        double totalSumm = 0;
        for (Employee employee : this.employees) {
            totalSumm = totalSumm + employee.getSalaryAmount();
        }
        System.out.println("Сумма затрат на зарплаты в месяц = " + totalSumm);

        return totalSumm;
    }

    //Найти сотрудника с минимальной зарплатой/Найти сотрудника с максимальной зарплатой.
    public void getMinSalary(int mode) {
        List<Employee> empList = fillEmployeeArrayList(this.employees);

        Employee employee = find(empList, BinaryOperator.minBy(Comparator.comparing(Employee::getSalaryAmount)));

        System.out.println("Минимальная зарплата за меcяц = " + employee.getSalaryAmount() + " у сотрудника (ФИО): " + getEmployeeInfoById(this.employees, employee.getEmployeeId(), 1) + " В отделе: " + employee.getDepartmentId());
    }


    public void getMaxSalary() {
        List<Employee> empList = fillEmployeeArrayList(this.employees);

        String direction;

        Employee employee = find(empList, BinaryOperator.maxBy(Comparator.comparing(Employee::getSalaryAmount)));

        System.out.println("Максимальная зарплата за меcяц = " + employee.getSalaryAmount() + " у сотрудника (ФИО): " + getEmployeeInfoById(this.employees, employee.getEmployeeId(), 1) + " В отделе: " + employee.getDepartmentId());
    }

    public Employee find(List<Employee> list, BinaryOperator<Employee> accumulator) {
        Employee result = null;
        for (Employee t : list) {
            if (result == null) {
                result = t;
            } else {
                result = accumulator.apply(result, t);
            }
        }
        return result;
    }

    //Подсчитать среднее значение зарплат
    public void calcAvarageSalary() {
        double avarageSalary = Math.round(calcTotalSalaryPayment(this.employees) / Employee.getEmployeeCount() * 100.0) / 100.0;
        System.out.println("Cреднее значение зарплат = " + avarageSalary);

    }

    public String getEmployeeInfoById(Employee[] employees, int id, int mode) {
        id--;
        String str;
        if (id > employees.length) {
            throw new NullPointerException("Передан не корректный идентификатор");
        }
        if (mode == 1) {
            str = employees[id].getLastName() + " " + employees[id].getFirstName() + " " + employees[id].getMiddleName();
        } else {
            str = "Идентификатор сотрудника - " + employees[id].getEmployeeId() +
                    ", ФИО - " + employees[id].getLastName() + " " + employees[id].getFirstName() + " " + employees[id].getMiddleName() +
                    ", Зарплата - " + employees[id].getSalaryAmount();
        }
        if (str.trim().equals("")) {
            throw new NullPointerException("Не указано атрибутов сотрудника по переданному идентификатору");
        }
        return str;
    }

    //Получить Ф. И. О. всех сотрудников
    public void printEmployeesInfo() {
        for (int i = 1; i <= Employee.getEmployeeCount(); i++) {
            System.out.println(getEmployeeInfoById(this.employees, i, 1));
        }
    }

    //Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    public void changeIncreaseSalary(double percent) {

        for (Employee employee : this.employees) {
            double incSalary = employee.getSalaryAmount() * percent / 100;
            employee.setSalaryAmount((double) Math.round((employee.getSalaryAmount() + incSalary) * 100) / 100);
        }
    }

    //Получить в качестве параметра номер отдела (1–5) и найти (Сотрудника с минимальной зарплатой) / (Сотрудника с максимальной зарплатой)
    public void getMinSalary(int mode, int departmentId) {

        List<Employee> empList = fillEmployeeArrayList(this.employees);

        Employee employee = find(empList, departmentId, BinaryOperator.minBy(Comparator.comparing(Employee::getSalaryAmount)));
        System.out.println("Минимальная зарплата за меcяц = " + employee.getSalaryAmount() + " у сотрудника (ФИО): " + getEmployeeInfoById(this.employees, employee.getEmployeeId(), 1) + " В отделе: " + employee.getDepartmentId());
    }

    public void getMaxSalary(int mode, int departmentId) {

        List<Employee> empList = fillEmployeeArrayList(this.employees);

        Employee employee;
        employee = find(empList, departmentId, BinaryOperator.maxBy(Comparator.comparing(Employee::getSalaryAmount)));
        System.out.println("Максимальная зарплата за меcяц = " + employee.getSalaryAmount() + " у сотрудника (ФИО): " + getEmployeeInfoById(this.employees, employee.getEmployeeId(), 1) + " В отделе: " + employee.getDepartmentId());
    }

    public Employee find(List<Employee> list, int departmentId, BinaryOperator<Employee> accumulator) {
        Employee result = null;
        for (Employee t : list) {
            if (result == null && t.getDepartmentId() == departmentId) {
                result = t;
            } else {
                if (t.getDepartmentId() == departmentId) {
                    result = accumulator.apply(result, t);
                }
            }
        }
        return result;
    }

    //Сумму затрат на зарплату по отделу.
    public void calcTotalSalaryPayment(int departmentId) {
        double totalSumm = 0;

        for (Employee employee : this.employees) {
            if (employee.getDepartmentId() == departmentId) {
                totalSumm = totalSumm + employee.getSalaryAmount();
            }
        }

        System.out.println("Сумма затрат на зарплаты по отделу: " + departmentId + " в месяц = " + totalSumm);
    }

    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
    public void changeIncreaseSalary(double percent, int departmetId) {
        for (Employee employee : this.employees) {
            if (employee.getDepartmentId() == departmetId) {
                double incSalary = employee.getSalaryAmount() * percent / 100;
                employee.setSalaryAmount((double) Math.round((employee.getSalaryAmount() + incSalary) * 100) / 100);
            }
        }
    }

    //Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public void printEmployeesInfo(int departmetId) {
        System.out.println("Список сотрудников отдела - " + departmetId + ":");
        for (Employee employee : this.employees) {
            if (employee != null) {
                if (employee.getDepartmentId() == departmetId) {
                    System.out.println(getEmployeeInfoById(this.employees, employee.getEmployeeId(), 2));
                }
            }
        }
    }

    public String printDepartmentEmployeesInfo(int departmetId) {
        String str = "";
        for (Employee employee : this.employees) {
            if (employee != null) {
                if (employee.getDepartmentId() == departmetId) {
                    str = getEmployeeInfoById(this.employees, employee.getEmployeeId(), 2);
                }
            }
        }
        return str;
    }


    public void getEmployesBySum(double summ, int mode) {
        List<Employee> empList = fillEmployeeArrayList(this.employees);

        for (Employee employee : this.employees) {
            if (mode == 1) {
                if (employee.getSalaryAmount() <= summ) {
                    System.out.println(getEmployeeInfoById(this.employees, employee.getEmployeeId(), 2));
                }
            }
            if (mode == 2) {
                if (employee.getSalaryAmount() > summ) {
                    System.out.println(getEmployeeInfoById(this.employees, employee.getEmployeeId(), 2));
                }
            }
        }

    }

}
