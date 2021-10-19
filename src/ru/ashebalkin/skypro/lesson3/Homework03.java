package ru.ashebalkin.skypro.lesson3;

public class Homework03 {

    public static void main(String[] args) {
        // write your code here
        task1(1);
        task2(2);
        task3(3);
        task4(4);
        task5(5);
        task6(6);
        task7(7);

    }

    public static void task1(int num){
        // Задание 1
        System.out.println("Ответ по заданию - " + num + ":");
        int clientOS = 0; //0 — iOS, 1 — Android.

        if (clientOS > 0){
            System.out.println("Установите версию приложения для Android по ссылке");
        } else System.out.println("Установите версию приложения для iOS по ссылке");
    }

    public static void task2(int num) {
        // Задание 2
        System.out.println("Ответ по заданию - " + num + ":");
        int clientDeviceYear = 2013, clientOS = 0;
        //0 — iOS, 1 — Android.

        if (clientDeviceYear < 2015) {
            if (clientOS > 0) {
                System.out.println("Установите версию приложения для Android по ссылке. Установите облегченную версию приложения для Android по ссылке");
            } else
                System.out.println("Установите версию приложения для iOS по ссылке. Установите облегченную версию приложения для iOS по ссылке");
        } else {
            if (clientOS > 0) {
                System.out.println("Установите версию приложения для Android по ссылке");
            } else System.out.println("Установите версию приложения для iOS по ссылке");
        }
    }

    public static void task3(int num) {
        // Задание 3
        System.out.println("Ответ по заданию - " + num + ":");
        int year = 1600;

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year + " год является високосным.");
        } else System.out.println(year + " год не является високосным.");
    }

    public static void task4(int num) {
        // Задание 4
        System.out.println("Ответ по заданию - " + num + ":");
        int deliveryDistance = 60, dayCount = 0, minDistance = 20, dist = 40, mindayCount = 1;

        if (deliveryDistance > minDistance) {
            dayCount = mindayCount + ((deliveryDistance - minDistance) / dist);
            if ((deliveryDistance - minDistance) % dist > 0) {
                dayCount++;
            }
            System.out.println("Потребуется дней: " + dayCount);
        } else {
            System.out.println("Потребуется дней: " + mindayCount);
        }
    }

    public static void task5(int num) {
        // Задание 5
        System.out.println("Ответ по заданию - " + num + ":");
        int monthNumber = 13;

        switch (monthNumber) {
            case 12:
            case 1:
            case 2:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
            default:
                System.out.println("Такого номера месяца в году не существует");
        }
    }

    public static void task6(int num) {
        // Задание 6
        System.out.println("Ответ по заданию - " + num + ":");

        int age = 19, salary = 58_000;
        double limitAmount = 0;

        if (age < 23) {
            limitAmount = salary * 2;
            if (salary >= 80_000) {
                limitAmount *= 1.5;
            } else{
                if (salary >= 50_000 && salary < 80_000){
                    limitAmount *= 1.2;
                }
            }
        } else {
            limitAmount = salary * 3;
            if (salary >= 80_000) {
                limitAmount *= 1.5;
            } else{
                if (salary >= 50_000 && salary < 80_000){
                    limitAmount *= 1.2;
                }
            }
        }
        System.out.println("Мы готовы выдать вам кредитную карту с лимитом " + limitAmount + " рублей");
    }

    public static void task7(int num) {
        // Задание 7
        System.out.println("Ответ по заданию - " + num + ":");

        int  age = 25, salary = 60_000, term = 12, wantedSum = 330_000;
        boolean decision = false;
        double rate = 0.1;
        double maxPaymentAmount = salary * 0.5;
        if (age > 23 && age < 30){
            rate += 0.005;
        } else if (age <= 23) {
            rate += 0.01;
        }
        if (salary > 80_000) {
            rate -= 0.007;
        }

        double minPaymentAmount = (wantedSum * rate) / term;

        if (maxPaymentAmount > minPaymentAmount){
            decision = true;
        }

        System.out.println(minPaymentAmount);
        if (decision == true) {
            System.out.println("Максимальный платеж при ЗП " + salary + " равен " + maxPaymentAmount + " рублей. Платеж по кредиту " + minPaymentAmount + " рублей. Одобрено.");
        } else
            System.out.println("Максимальный платеж при ЗП " + salary + " равен " + maxPaymentAmount + " рублей. Платеж по кредиту " + minPaymentAmount + " рублей. Отклонено.");
    }

}
