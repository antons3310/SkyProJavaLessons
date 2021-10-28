package ru.ashebalkin.skypro.lesson7;

import java.time.LocalDate;
import java.util.Arrays;

public class Homework07 {

    public static void main (String [] arr){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    public static void checkAndPrint(int num) {
        if (num % 4 == 0 && num % 100 != 0 || num % 400 == 0) {
            System.out.println(num + " - високосный год");
        } else System.out.println(num + " - не високосный год");
    }

    public static void test1() {
        int year = 1500;
        checkAndPrint(year);
    }

    public static int checkOsAndYear(int osType, int productionYear, int currentYear) {
        if (currentYear == 0) {
            currentYear = LocalDate.now().getYear();
        }
        if (productionYear < currentYear) {
            if (osType > 0) {
                return 1;
            } else {
                return 2;
            }
        } else {
            if (osType > 0) {
                return 3;
            } else return 4;
        }
    }

    public static void printResultcheckOsAndYear(int var) {
        if (var == 1) {
            System.out.println("Установите версию приложения для Android по ссылке. Установите облегченную версию приложения для Android по ссылке");
        } else {
            if (var == 2) {
                System.out.println("Установите версию приложения для iOS по ссылке. Установите облегченную версию приложения для iOS по ссылке");
            } else {
                if (var == 3) {
                    System.out.println("Установите версию приложения для Android по ссылке");
                } else {
                    System.out.println("Установите версию приложения для iOS по ссылке");
                }
            }
        }
    }

    public static void test2() {
        int os = 1;//0 — iOS, 1 — Android.
        int prodYear = 2019;
        int curYear = 0;
        int result = checkOsAndYear(os,prodYear,curYear);
        printResultcheckOsAndYear(result);

    }

    public static int calcDeliveryTerm(int distance) {
        int dayCount = 0;
        int minDistance = 20;
        int dist = 40;
        int mindayCount = 1;

        if (distance > minDistance) {
            dayCount = mindayCount + ((distance - minDistance) / dist);
            if ((distance - minDistance) % dist > 0) {
                dayCount++;
            }
            return dayCount;
        } else {
            dayCount = mindayCount;
            return dayCount;
        }
    }

    public static void printDeliveryDays(int txt) {
        System.out.println("Потребуется дней: " + txt);
    }

    public static void test3() {
        int deliverydDistance = 150;
        int days = calcDeliveryTerm(deliverydDistance);
        printDeliveryDays(days);
    }

    public static void strChecker(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i+1 < chars.length){
                if (chars[i] == chars[i+1] ){
                    System.out.println("В переданной строке обнаружен дубль символа: - " + chars[i] + ". Первый дубль в позиции: " + (i+1));
                    return;
                }
            }
        }
    }

    public static void test4() {
        String strForCheck = "abccddefgghiijjkk";
        strChecker(strForCheck);
    }

    public static void reversArr(int [] arr) {
        int a = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            a = arr[i] + arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = a - arr[arr.length - 1 - i];
            arr[i] = a - arr[arr.length - 1 - i];
        }
    }

    public static void test5() {
        int [] arr = { 3, 2, 1, 6, 5};
        reversArr(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static double [] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        double [] arr = new double[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public static double calSum (double [] summArr) {
        double summ = 0;
        for (double i : summArr) {
            summ = summ + i;
        }
        return summ;
    }

    public static double calcAvg(double summ, int count) {
        double sumAvg = summ / count;
        return  sumAvg;
    }

    public static double roundSumm(double summ) {
        double scale = Math.pow(10, 2);
        double result = Math.ceil(summ * scale) / scale;
        return result;
    }

    public static void sumPrint (double sum) {
        System.out.println("Средняя сумма трат за месяц составила " + sum + " рублей");
    }

    public static void test6() {
        double [] arr = generateRandomArray();
        double summ = calSum(arr);
        double sumAvg = calcAvg(summ, arr.length);
        sumAvg = roundSumm(sumAvg);
        sumPrint(sumAvg);
    }
}
