package ru.ashebalkin.skypro.coursework01;

import ru.ashebalkin.skypro.lesson8.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class Coursework01 {

    public static void main(String[] args) {
        Employee[] employees = baseLevel();
        advancedLevel(employees);
        hardLevel();
    }

    public static Employee[] baseLevel() {
        String str = "#";
        String s1 = str.repeat(40);
        Employee[] employees = new Employee[10];

        Employee anton = new Employee("Шебалкин", "Антон", "Сергеевич", 1, 25874.75);
        Employee alina = new Employee("Петрова", "Алина", "Евгеньевна", 1, 57412.49);
        Employee sveta = new Employee("Епифанов", "Светлана", "Валентиновна", 2, 85221.17);
        Employee tatiana = new Employee("Михайлова", "Татьяна", "Михайловна", 2, 17458.50);
        Employee olga = new Employee("Михайлова", "Ольга", "Михайловна", 3, 36000.00);
        Employee alex = new Employee("Павлов", "Алексей", "Леонидович", 3, 48756.88);
        Employee andrey = new Employee("Новиков", "Андрей", "Валентиновыч", 4, 54898.44);
        Employee dima = new Employee("Дядюра", "Дмитрий", "Анатольевич", 4, 478844.72);
        Employee sergey = new Employee("Ломака", "Сергей", "Дмитриевич", 5, 58114.13);
        Employee alexey = new Employee("Грошев", "Алексей", "Константиновчи", 5, 87444.55);

        fillCurEmployeekArr(employees);

        getEmployeeInfo(employees);
        System.out.println(s1);

        calcTotalSalaryPayment(employees);
        System.out.println(s1);

        getMinMaxSalary(employees, 1);
        System.out.println(s1);

        getMinMaxSalary(employees, 2);
        System.out.println(s1);

        calcAvarageSalary(employees);
        System.out.println(s1);

        printEmployeesInfo(employees);
        System.out.println(s1);

        return employees;
    }

    public static void fillCurEmployeekArr(Employee[] employees) {
        for (int i = 0; i < Employee.getEmployeesList().size(); i++) {
            employees[i] = (Employee) Employee.getEmployeesList().get(i);
        }
    }

    public static List<Employee> fillCurrEmployeeList(Employee[] employees) {
        List<Employee> employeeList = new ArrayList<Employee>();
        for (int i = 0; i < Employee.getEmployeesList().size(); i++) {
            employeeList.add(employees[i]);
        }
        return employeeList;
    }

    //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString))
    public static void getEmployeeInfo(Employee[] employees) {
        for (int i = 0; i < Employee.getEmployeeCount(); i++) {
            System.out.println(employees[i]);
        }
    }

    //Посчитать сумму затрат на зарплаты в месяц
    public static double calcTotalSalaryPayment(Employee[] employees) {
        double totalSumm = 0;
        for (Employee employee : employees) {
            totalSumm = totalSumm + employee.getSalaryAmount();
        }
        System.out.println("Сумма затрат на зарплаты в месяц = " + totalSumm);

        return totalSumm;
    }

    //Найти сотрудника с минимальной зарплатой/Найти сотрудника с максимальной зарплатой.
    //1 - для минимума
    //2 - для максимума
    public static void getMinMaxSalary(Employee[] employees, int mode) {
        List<Employee> empList = fillCurrEmployeeList(employees);

        String direction;
        if (mode == 1) {
            direction = "Минимальная";
        } else {
            direction = "Максимальная";
        }

        Employee employee;
        if (mode == 1) {
            employee = find(empList, BinaryOperator.minBy(Comparator.comparing(Employee::getSalaryAmount)));
        } else {
            employee = find(empList, BinaryOperator.maxBy(Comparator.comparing(Employee::getSalaryAmount)));
        }

        System.out.println(direction + " зарплата за меcяц = " + employee.getSalaryAmount() + " у сотрудника (ФИО): " + getEmployeeInfoById(employees, employee.getEmployeeId(), 1) + " В отделе: " + employee.getDepartmentId());
    }

    public static Employee find(List<Employee> list, BinaryOperator<Employee> accumulator) {
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
    public static void calcAvarageSalary(Employee[] employees) {
        double avarageSalary = Math.round(calcTotalSalaryPayment(employees) / Employee.getEmployeeCount() * 100.0) / 100.0;
        System.out.println("Cреднее значение зарплат = " + avarageSalary);

    }

    public static String getEmployeeInfoById(Employee[] employees, int id, int mode) {
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
    public static void printEmployeesInfo(Employee[] employees) {
        for (int i = 1; i <= Employee.getEmployeeCount(); i++) {
            System.out.println(getEmployeeInfoById(employees, i, 1));
        }
    }

    public static void advancedLevel(Employee[] employees) {
        String str = "#";
        String s1 = str.repeat(40);

        double s = 16.3; //// значение в процентах для индексации

        changeIncreaseSalary(employees, s);

        getEmployeeInfo(employees);
        System.out.println(s1);

        int dep = 2; //идентификатор отдела (число от 1 до 5)

        getMinMaxSalary(employees, 1, dep);
        System.out.println(s1);

        getMinMaxSalary(employees, 2, dep);
        System.out.println(s1);

        calcTotalSalaryPayment(employees, dep);
        System.out.println(s1);

        changeIncreaseSalary(employees, s, dep);
        System.out.println(s1);

        getEmployeeInfo(employees);
        System.out.println(s1);

        printEmployeesInfo(employees, dep);
        System.out.println(s1);

        double summ = 50000;
        getEmployesBySum(employees, summ, 1);
        System.out.println(s1);

        getEmployesBySum(employees, summ, 2);
        System.out.println(s1);

    }

    //Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    public static void changeIncreaseSalary(Employee[] employees, double percent) {

        for (Employee employee : employees) {
            double incSalary = employee.getSalaryAmount() * percent / 100;
            employee.setSalaryAmount((double) Math.round((employee.getSalaryAmount() + incSalary) * 100) / 100);
        }
    }

    //Получить в качестве параметра номер отдела (1–5) и найти (Сотрудника с минимальной зарплатой) / (Сотрудника с максимальной зарплатой)
    //1 - для минимума
    //2 - для максимума
    public static void getMinMaxSalary(Employee[] employees, int mode, int departmentId) {

        List<Employee> empList = fillCurrEmployeeList(employees);

        String direction;
        if (mode == 1) {
            direction = "Минимальная";
        } else {
            direction = "Максимальная";
        }

        Employee employee;
        if (mode == 1) {
            employee = find(empList, departmentId, BinaryOperator.minBy(Comparator.comparing(Employee::getSalaryAmount)));
        } else {
            employee = find(empList, departmentId, BinaryOperator.maxBy(Comparator.comparing(Employee::getSalaryAmount)));
        }
        System.out.println(direction + " зарплата за меcяц = " + employee.getSalaryAmount() + " у сотрудника (ФИО): " + getEmployeeInfoById(employees, employee.getEmployeeId(), 1) + " В отделе: " + employee.getDepartmentId());
    }

    public static Employee find(List<Employee> list, int departmentId, BinaryOperator<Employee> accumulator) {
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
    public static void calcTotalSalaryPayment(Employee[] employees, int departmentId) {
        double totalSumm = 0;

        for (Employee employee : employees) {
            if (employee.getDepartmentId() == departmentId) {
                totalSumm = totalSumm + employee.getSalaryAmount();
            }
        }

        System.out.println("Сумма затрат на зарплаты по отделу: " + departmentId + " в месяц = " + totalSumm);
    }

    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
    public static void changeIncreaseSalary(Employee[] employees, double percent, int departmetId) {
        for (Employee employee : employees) {
            if (employee.getDepartmentId() == departmetId) {
                double incSalary = employee.getSalaryAmount() * percent / 100;
                employee.setSalaryAmount((double) Math.round((employee.getSalaryAmount() + incSalary) * 100) / 100);
            }
        }
    }

    //Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public static void printEmployeesInfo(Employee[] employees, int departmetId) {
        System.out.println("Список сотрудников отдела: " + departmetId);
        for (Employee employee : employees) {
            if (employee.getDepartmentId() == departmetId) {
                System.out.println(getEmployeeInfoById(employees, employee.getEmployeeId(), 2));

            }
        }
    }

    public static void getEmployesBySum(Employee[] employees, double summ, int mode) {
        List<Employee> empList = fillCurrEmployeeList(employees);

        for (Employee employee : employees) {
            if (mode == 1) {
                if (employee.getSalaryAmount() <= summ) {
                    System.out.println(getEmployeeInfoById(employees, employee.getEmployeeId(), 2));
                }
            }
            if (mode == 2) {
                if (employee.getSalaryAmount() > summ) {
                    System.out.println(getEmployeeInfoById(employees, employee.getEmployeeId(), 2));
                }
            }
        }

    }

    public static void hardLevel() {
        String str = "#";
        String s1 = str.repeat(40);
        EmployeeBook book = new EmployeeBook(15);

        book.addNewEmployee("Терещено", "Елена","Витальевна",3,68444.32);
        book.getEmployeeInfo();
        System.out.println(s1);

        book.deleteEmployeeFromBook(11);
        book.getEmployeeInfo();
        System.out.println(s1);

        book.deleteEmployeeFromBook("Павлов", "Алексей", "Леонидович");
        book.getEmployeeInfo();
        System.out.println(s1);

        book.updateEmployeeInfo("Дядюра", "Дмитрий", "Анатольевич", 999999, 3);
        book.getEmployeeInfo();
        System.out.println(s1);

        book.printEmployeeByDepId();
        System.out.println(s1);


    }

}
