package ru.ashebalkin.skypro.lesson6;

import java.util.Locale;

public class Homework06 {
    public static void main (String [] arr){
        test1(1,0);
        test2();
        test3();
        test4();
        test4_1();
        test5();
        test5_1();
        test6();
        test7();
        test8();
    }

    public static String test1(int printOnly, int delimeter) {
        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName  = "Ivanov";
        String fullName = "";

        if (delimeter == 1) {
            fullName = lastName + " - " + firstName + " - " + middleName;
        } else {
            fullName = lastName + " " + firstName + " " + middleName;
        }

        if (printOnly == 1) {
            System.out.println("ФИО сотрудника — " + fullName);
        }

        return fullName;
    }

    public static void test2() {
        String s1 = test1(0,0);
        System.out.println("Данные ФИО сотрудника для заполнения отчета — " + s1.toUpperCase());
        //System.out.println("Данные ФИО сотрудника для заполнения отчета — " + test1(0).toUpperCase());
    }

    public static void test3() {
        String s1 = test1(0,0);
        System.out.println(s1.replaceAll(" ","; "));
    }

    public static void test4() {
        String fullName  = "Иванов Семён Семёнович ";
        if (fullName.contains("ё")) {
            System.out.println("Данные ФИО сотрудника — " + fullName.replaceAll("ё","е"));
        } else {
            System.out.println("Данные ФИО сотрудника — " + fullName);
        }
    }

    public static void test4_1() {
        String fullName  = "Иванов Семён СемЁнович ";

        String [] wordsName = fullName.split(" ");

        String resultFullName = "";

        for (String word: wordsName) {
            if (word.contains("ё") || word.contains("Ё") ) {
                word = word.replace('ё','e');
                word = word.replace('Ё','Е');
            }
            resultFullName = resultFullName + " " + word;
        }
        System.out.println("Данные ФИО сотрудника — " + resultFullName);
    }
    public static void test5() {
        String firstName = "";
        String lastName = "";
        String middleName = "";
        //получим строку из упражнения 1
        String fullName = test1(0,1);
        // форматируем строку
        fullName = fullName.replaceAll("-","");
        fullName = fullName.replaceAll("  "," ");

        int startpos = fullName.indexOf(" ");

        while (startpos >=0 ) {
            if (lastName.isEmpty()) {
                lastName = fullName.substring(0,startpos);
                fullName = fullName.substring(startpos + 1,fullName.length());
                } else {
                if (firstName.isEmpty()) {
                    firstName = fullName.substring(0,startpos);
                    fullName = fullName.substring(startpos + 1,fullName.length());
                }
            }
            startpos = fullName.indexOf(" ");
        }
        middleName = fullName;

        System.out.println("Фамилия cотрудника — " + lastName);
        System.out.println("Имя сотрудника — " + firstName);
        System.out.println("Отчество сотрудника — " + middleName);
    }

    public static void test5_1() {
//        int count = 0;
//        for (int i = 0; i < fullName.length(); i++) {
//            if (fullName.charAt(i) == ' ') {
//                count++;
//            }
//        }

        String fullName = test1(0,1);
        // форматируем строку
        fullName = fullName.replaceAll("-","");
        fullName = fullName.replaceAll("  "," ");

        //Фамилия
        int startpos = fullName.indexOf(" ");
        String middleName = fullName.substring(0,startpos);
        fullName = fullName.substring(startpos + 1,fullName.length());

        //Имя
        startpos = fullName.indexOf(" ");
        String firstName = fullName.substring(0,startpos);
        fullName = fullName.substring(startpos + 1,fullName.length());

        //Отчество
        String lastName = fullName;

        System.out.println("Фамилия cотрудника — " + middleName);
        System.out.println("Имя сотрудника — " + firstName);
        System.out.println("Отчество сотрудника — " + lastName);
    }

    public static void test6() {
        String fullName = "ivanov ivan ivanovich";

        char[] symbols  = fullName.toCharArray();

        symbols [0] = Character.toUpperCase(symbols [0]);
        for (int a = 0; a < symbols .length; a++){
            if (symbols [a] == ' ') {
                symbols [a + 1] = Character.toUpperCase(symbols [a + 1]);
            }
        }
        System.out.println("Верное написание Ф. И. О. сотрудника сзаглавных букв —  " + new String(symbols));
    }

    public static void test7() {
        StringBuilder num1 = new StringBuilder("135");
        StringBuilder num2 = new StringBuilder("246");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < num1.length(); i++) {
            result.append(num1.charAt(i));
            result.append(num2.charAt(i));
        }
        System.out.println("Данные строки — " + result);
    }

    public static void test8() {
        String txt = "aabccddefgghiijjkk";

        char[] chars = txt.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (i+1 < chars.length){
                if (chars[i] == chars[i+1] ){
                    result.append(chars[i]);
                }
            }
        }
        System.out.println(result);
    }
}


