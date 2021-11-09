package ru.ashebalkin.skypro.coursework01;

public class Coursework01 {

    public static void main(String[] args) {
        Employee[] employees = baseLevel();
        advancedLevel(employees);
        hardLevel();
    }

    public static Employee[] baseLevel() {
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
        calcTotalSalaryPayment(employees);
        getMinMaxSalary(employees, 1);
        getMinMaxSalary(employees, 2);
        calcAvarageSalary(employees);
        printEmployeesInfo(employees);

        return employees;
    }

    public static void fillCurEmployeekArr(Employee[] employees) {
        for (int i = 0; i < Employee.getEmployeesList().size(); i++) {
            employees[i] = (Employee) Employee.getEmployeesList().get(i);
        }
    }

    public static void getEmployeeInfo(Employee[] employees) {
        for (int i = 0; i < Employee.getEmployeeCount(); i++) {
            System.out.println(employees[i]);
        }
    }

    public static double calcTotalSalaryPayment(Employee[] employees) {
        double totalSumm = 0;
        for (int i = 0; i < employees.length; i++) {
            totalSumm = totalSumm + employees[i].getSalaryAmount();
        }
        System.out.println("Сумма затрат на зарплаты в месяц = " + totalSumm);

        return totalSumm;
    }

    //один метод для максимума и минимума в зависимости от параметра
    //1 - для минимума
    //2 - для максимума
    public static void getMinMaxSalary(Employee[] employees, int mode) {
        double salary = employees[0].getSalaryAmount();
        int currId = employees[0].getEmployeeId();

        String direction = "";
        if (mode == 1) {
            direction = "Минимальная";
        } else {
            direction = "Максимальная";
        }

        if (mode == 2) {
            for (int i = 1; i < employees.length; i++) {
                if (employees[i].getSalaryAmount() > salary) {
                    salary = employees[i].getSalaryAmount();
                    currId = employees[i].getEmployeeId();
                }
            }
        }

        if (mode == 1) {
            for (int i = 1; i < employees.length; i++) {
                if (employees[i].getSalaryAmount() < salary) {
                    salary = employees[i].getSalaryAmount();
                    currId = employees[i].getEmployeeId();
                }
            }
        }

        System.out.println(direction + " зарплата за меcяц = " + salary + " у сотрудника (ФИО): " + getEmployeeInfoById(employees, currId));
    }

    public static void calcAvarageSalary(Employee[] employees) {
        double avarageSalary = Math.round(calcTotalSalaryPayment(employees) / Employee.getEmployeeCount() * 100.0) / 100.0;
        System.out.println("Cреднее значение зарплат = " + avarageSalary);

    }

    public static String getEmployeeInfoById(Employee[] employees, int id) {
        String str = "";
        if (id > employees.length) {
            throw new NullPointerException("Передан не корректный идентификатор");
        }
        str = employees[id - 1].getLastName() + " " + employees[id - 1].getFirstName() + " " + employees[id - 1].getMiddleName();
        if (str.trim().equals("")) {
            throw new NullPointerException("Не указано атрибутов сотрудника по переданному идентификатору");
        }
        return str;
    }

    public static void printEmployeesInfo(Employee[] employees) {
        for (int i = 1; i <= Employee.getEmployeeCount(); i++) {
            System.out.println(getEmployeeInfoById(employees, i));
        }
    }

    public static void advancedLevel(Employee[] employees) {

        double s = 16.3; //// значение в процентах
        changeIncreaseSalary(employees,s);
        getEmployeeInfo(employees);
        int dep = 2; //идентификатор отдела (число от 1 до 5)
        calcTotalSalaryPaymentByDepartmentId(employees, dep);
        getMinMaxSalary(employees, 1, dep);
        getMinMaxSalary(employees, 2, dep);


    }

    public static void changeIncreaseSalary(Employee[] employees, double percent) {
        double incSalary = 0;

        for (int i = 0; i < employees.length; i++) {
            incSalary = employees[i].getSalaryAmount() * percent / 100;
            employees[i].setSalaryAmount((double) Math.round((employees[i].getSalaryAmount() + incSalary)*100)/100 );
        }
    }

    //один метод для максимума и минимума в зависимости от параметра
    //1 - для минимума
    //2 - для максимума
    public static void getMinMaxSalary(Employee[] employees, int mode, int departmentId) {
        double salary = 0;
        int currId = 0;

        String direction = "";
        if (mode == 1) {
            direction = "Минимальная";
        } else {
            direction = "Максимальная";
        }

        if (mode == 2) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartmentId() == departmentId){
                    salary = employees[i].getSalaryAmount();
                    currId = employees[i].getEmployeeId();
                    if (employees[i].getSalaryAmount() > salary) {
                        salary = employees[i].getSalaryAmount();
                        currId = employees[i].getEmployeeId();
                    }
                }
            }
        }

        if (mode == 1) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getDepartmentId() == departmentId){
                    salary = employees[i].getSalaryAmount();
                    currId = employees[i].getEmployeeId();
                    if (employees[i].getSalaryAmount() < salary) {
                        salary = employees[i].getSalaryAmount();
                        currId = employees[i].getEmployeeId();
                    }
                }
            }
        }

        System.out.println(direction + " зарплата за меcяц = " + salary + " у сотрудника (ФИО): " + getEmployeeInfoById(employees, currId) + " В отделе: " + departmentId);
    }

    public static double calcTotalSalaryPaymentByDepartmentId(Employee[] employees, int departmentId) {
        double totalSumm = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartmentId() == departmentId){
                totalSumm = totalSumm + employees[i].getSalaryAmount();
            }
        }
        System.out.println("Сумма затрат на зарплаты по отделу: " + departmentId + " в месяц = " + totalSumm);

        return totalSumm;
    }

    public static void hardLevel() {

    }

}
