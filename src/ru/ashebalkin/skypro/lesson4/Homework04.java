package ru.ashebalkin.skypro.lesson4;

public class Homework04 {

    public static void main(String[] args) {
        // write your code here
        test1(1);
        test2(2);
        test3(3);
        test4(4);
        test5(5);
    }

    public static void test1(int number) {
        System.out.println("Решение по заданию - " + number + ":");

        int i = 1;
        while (i < 11) {
            System.out.print(i + " ");
            i ++;
        }

        System.out.println("\n");

        for (i = 10; i >= 1; i --) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public static void test2(int number) {
        System.out.println("Решение по заданию - " + number + ":");

        int fridayNum = 7;

        for (int i = fridayNum; i <= 31; i = i + 7) {
            System.out.println("Сегодня пятница, " + i + "-е число. Необходимо подготовить отчет.");
        }
    }

    public static void test3(int number) {
        System.out.println("Решение по заданию - " + number + ":");

        int currentYeat = 2021;
        int beginYear = currentYeat - 200;
        int endYear = currentYeat + 100;

        for (int i = 0; i <= endYear; i += 79) {
            if (i > beginYear) {
                System.out.println(i);
            }
        }
    }

    public static void test4(int number) {
        System.out.println("Решение по заданию - " + number + ":");

        for (int i = 1; i <= 30; i ++){
            System.out.print(i + ": ");
            if (i % 3 == 0 ){
                System.out.print("ping ");
            }

            if (i % 5 == 0 ){
                System.out.print("pong");
            }

            System.out.println();
        }
    }

    public static void test5(int number) {
        System.out.println("Решение по заданию - " + number + ":");

        int num = 20, a = 0, b = 1, c = 0;
        System.out.print(a + ", " + b);
        for(int i = 1; i <= num; i ++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(", " + c);
        }
        System.out.println();
    }
}
