package ru.ashebalkin.skypro.lesson2;

public class Homework02 {

    public static void main(String[] args) {
        // write your code here
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task8_1();


    }

    public static void task1() {
        //Задача 1
        byte a1 = 1;
        short b1 = 2;
        int c1 = 3;
        long d1 = 365L;
        float f1 = 5.5F;
        double e1 = 6.6;
        char t = 't';
        boolean bo = true;

        System.out.println("Переменная a1 = " + a1);
        System.out.println("Переменная b1 = " + b1);
        System.out.println("Переменная c1 = " + c1);
        System.out.println("Переменная d1 = " + d1);
        System.out.println("Переменная e1 = " + e1);
        System.out.println("Переменная f1 = " + f1);
        System.out.println("Переменная t = " + t);
        System.out.println("Переменная bo = " + bo);
    }

    public static void task2() {
        //Задача 2

        float firstBoxerWeight = 78.2F;
        float secondBoxerWeight = 82.7F;

        float totalWeight = firstBoxerWeight + secondBoxerWeight;
        System.out.println("Общий весь бойцой = " + totalWeight);

        float diffWeight = Math.abs(firstBoxerWeight - secondBoxerWeight);
        System.out.println("Разница в весе = " + diffWeight + " кг.");

    }

    public static void task3() {
        //Задача 3

        // рецепт
        byte bananaCount = 5;
        byte milkPortionCount = 2;
        byte iceCreamCount = 2;
        byte eagsCount = 4;
        //вес одного ингридиента
        byte babanaWeight = 80;
        byte milkPortionWeight = 105;
        byte iceCreamWeight = 100;
        byte eagsWeight = 70;

        float coctailWeight = bananaCount * babanaWeight + milkPortionCount * milkPortionWeight + iceCreamCount + iceCreamWeight + eagsCount * eagsWeight;
        System.out.println("Вес завтравка, гр: " + coctailWeight);
        coctailWeight = coctailWeight / 1000;
        System.out.println("Вес завтравка, кл: " + coctailWeight);

    }

    public static void task4() {
        //Задача 4

        byte goalWeightKilo = 7;
        short minLoseWeightGr = 250;
        short maxLoseWeightGr = 500;

        int goalWeightGr = goalWeightKilo * 1000;

        int minDays =  goalWeightGr / minLoseWeightGr;
        System.out.println("Минимальное количество дней " + minDays);
        int maxDays =  goalWeightGr / maxLoseWeightGr;
        System.out.println("Максимальное количество дней " + maxDays);
        int avgDays = (minDays + maxDays) / 2;
        System.out.println("Среднее количество дней " + avgDays);

    }

    public static void task5() {
        //Задача 5
        short minYearCount = 3;
        short salIncPer = 10;

        int mashaSal = 67_760;
        int denSal = 83_690;
        int krisSal = 76_230;
        byte monthCount = 12;

        int yearprevmashaSal = mashaSal * monthCount;
        int yearprevdenSal = denSal * monthCount;
        int yearprevkrisSal = krisSal * monthCount;

        int totalmashaSal = mashaSal + mashaSal * salIncPer / 100;
        int totaldenSal = denSal + denSal * salIncPer / 100;
        int totalkrisSal = krisSal + krisSal * salIncPer / 100;

        int yeartotalmashaSal = totalmashaSal * monthCount;
        int yeartotaldenSal = totaldenSal * monthCount;
        int yeartotalkrisSal = totalkrisSal * monthCount;

        System.out.println("Маша теперь получает " + yeartotalmashaSal + " рублей. Годовой доход вырос на " + (yeartotalmashaSal - yearprevmashaSal) + " рублей.");
        System.out.println("Маша теперь получает " + yeartotaldenSal + " рублей. Годовой доход вырос на " + (yeartotaldenSal - yearprevdenSal) + " рублей.");
        System.out.println("Маша теперь получает " + yeartotalkrisSal + " рублей. Годовой доход вырос на " + (yeartotalkrisSal - yearprevkrisSal) + " рублей.");
    }

    public static void task6() {
        //Задача 6
        byte a = 12;
        byte b = 27;
        byte c = 44;
        byte d = 15;
        byte e = 9;

        int result = a * (b + (c - d * e));
        System.out.println("Результат result: " + result);
        result = -result;
        System.out.println("Результат result: " + result);
        result = -result;
        System.out.println("Результат result: " + result);
    }

    public static void task7() {
        //Задача 7
        int a2 = 5;
        int b2 = 7;
        System.out.println("Результат a2 до преобразований: " + a2);
        System.out.println("Результат b2 до преобразований: " + b2);
        //b2 = a2 - b2 + b2;
        a2=a2+b2;
        b2=a2-b2;
        a2=a2-b2;
        System.out.println("Результат a2: " + a2);
        System.out.println("Результат b2: " + b2);
    }

    public static void task8() {
        //Задача 8
        int a3 = 748;
        System.out.println("Результат a3: " + a3);
        int b3 = a3 / 10;
        b3 = b3 - (b3 / 10) * 10;
        System.out.println("Результат b3: " + b3);
    }

    public static void task8_1() {
        //альтернативное
        int a4 = 748;
        System.out.println("Результат a3: " + a4);
        int b4 = (a4 % 100 - a4 % 10) / 10;
        System.out.println("Результат b3: " + b4);
    }
}
