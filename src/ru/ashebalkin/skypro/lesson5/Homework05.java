package ru.ashebalkin.skypro.lesson5;

public class Homework05 {

    public static void main(String[] args) {
        // write your code here
/*
        test1();
        test2();
        test3();
        test4();
*/
        test5();
/*
        test6();
        test7();
        test8();
        test9();
*/
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }


/*
        for (int index = 0; index < arr.length; index++) {
            if (index == arr.length - 1) {
                System.out.println(arr[index]);
                break;
            }
            System.out.print(arr[index] + " ");
        }
*/

    public static void test1() {
        int[] arr = generateRandomArray();

        int summ = 0;

        for (int i : arr) {
            summ = summ + i;
        }
        System.out.println("Сумма трат за месяц составила " + summ +" рублей");

        int summAlt = 0;

        for (int i = 0; i < arr.length; i++) {
            summAlt = summAlt + arr[i];
        }
        System.out.println("Сумма трат за месяц составила " + summAlt +" рублей");
    }

    public static void test2() {
        int[] arr = generateRandomArray();
        int maxSum = 0;

        for (int i : arr) {
            if (maxSum < i) {
                maxSum = i;
            }
        }

        int minSum = arr[0];
        for (int i : arr) {
            if (minSum > i) {
                minSum = i;
            }
        }

        System.out.println("Минимальная сумма трат за день составила " + minSum + " рублей. Максимальная сумма трат за день составила " + maxSum + " рублей");
    }

    public static void test3() {
        int[] arr = generateRandomArray();

        int summ = 0;

        for (int i : arr) {
            summ = summ + i;
        }

        int sumAvg = summ / arr.length;

        System.out.println("Средняя сумма трат за месяц составила " + sumAvg + " рублей");
    }

    public static void test4() {
        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};

        for (int index = 0; index < reverseFullName.length; index++) {
            if (index == reverseFullName.length - 1) {
                System.out.println(reverseFullName[index]);
                break;
            }
            System.out.print(reverseFullName[index] + " ");
        }

        for (int i = reverseFullName.length-1; i >= 0; i = i-1) {
            System.out.print(reverseFullName[i]);
        }
    }

    public static void test5() {

        int [] [] field = new int[3][3];

        for (int [] row : field) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public static void test6() {

    }

    public static void test7() {

    }

    public static void test8() {

    }

    public static void test9() {

    }
}
