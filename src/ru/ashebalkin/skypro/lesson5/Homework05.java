package ru.ashebalkin.skypro.lesson5;

import java.util.Arrays;

public class Homework05 {

    public static void main(String[] args) {
        // write your code here
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
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
        int n = 3;

        int [][] matrix = new int[n][n];
        int count = matrix.length;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (x==y) {
                    matrix[x][y] = 1;
                }
                if (y == count-1) {
                    matrix[x][y] = 1;
                }
            }
            count--;
        }

        for (int[] x : matrix) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }


    }

    public static void test6() {
        int [] arr = new int[] {6,5,4,3,2,1};
        System.out.println(Arrays.toString(arr));

        int [] addArr = new int[6];

        int len = addArr.length - 1;

        for (int i = arr.length-1; i >= 0; i--) {
            addArr[len - i] = arr[i];
        }

        System.out.println(Arrays.toString(addArr));

    }

    public static void test7() {
        int [] arr = new int[] {6,5,4,3,2,1};
        System.out.println(Arrays.toString(arr));

        int a = 0;
        int len = arr.length;

        for (int i = 0; i < len / 2; i++) {
            arr[i] = arr[i] + arr[len - 1 - i];
            arr[len - 1 - i] = arr[i] - arr[len - 1 - i];
            arr[i] = arr[i] - arr[len - 1 - i];
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void test8() {
        int [] arr = new int[]  {-6,2,5,-8,8,10,4,-7,12,1};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);

        int target = 2;
        boolean getResult = false;

        for (int i = 0 ; i < arr.length; i++) {
            if (getResult) {
                break;
            } else {
                for (int i1 = i+1; i1 < arr.length; i1++) {
                    if ((arr[i] + arr[i1]) == target) {
                        System.out.println(("Искомая пара чисел: " + arr[i] + " и " + arr[i1]));
                        getResult = true;
                        break;
                    }
                }
            }
        }
    }

    public static void test9() {
        int [] arr = new int[]  {-6,2,5,-8,8,10,4,-7,12,1};
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);

        int target = 2;

        for (int i = 0 ; i < arr.length; i++) {
            for (int i1 = i+1; i1 < arr.length; i1++) {
                if ((arr[i] + arr[i1]) == target) {
                    System.out.println(("Искомая пара чисел: " + arr[i] + " и " + arr[i1]));
                }
            }
        }
    }
}
