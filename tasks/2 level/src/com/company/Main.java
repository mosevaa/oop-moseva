package com.company;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        //int[] mas = {44, 32, 86, 19};
        System.out.println (sameAscii("EdAbIt", "EDABIT"));
    }
    //1.Теша шел по прямой улице, по обеим сторонам которой стояло ровно n одинаковых домов.
    // Номера домов на улице выглядят так:
    // Она заметила, что четные дома увеличиваются справа, а нечетные уменьшаются слева.
    // Создайте функцию, которая принимает номер дома и длину улицы n и возвращает номер дома на противоположной стороне.
    public static int oppositeHouse (int numb, int n) {
        int[][] houses = new int[n][2];
        for (int i = 0; i < n; i ++){
            houses[i][0] = 2 * i + 1;
            houses[i][1] = n * 2 - i *2;
        }
        if (numb % 2 != 0 ){
            int i = (numb-1)/2;
            return houses[i][1];
        }
        else {
            int i = n - numb/2;
            return houses[i][0];
        }
    }


    // 2. Создайте метод, который принимает строку (имя и фамилию человека) и возвращает строку с заменой имени и фамилии.
    public static String nameShuffle (String s) {
        String[] words = s.split(" ");
        return String.join(" ", words[1], words[0] );
    }


    // 3. Создайте функцию, которая принимает два аргумента: исходную цену и процент скидки в виде целых чисел и
    // возвращает конечную цену после скидки.
    public static double discount(int c, int s){
        return (double) c*(100-s)/100;
    }


    // 4.Создайте функцию, которая принимает массив и возвращает разницу между наибольшим и наименьшим числами.
    public static int differenceMaxMin (int[] mas) {
        int max = mas[0], min = mas[0];
        for (int i = 0; i < mas.length; i++){
            if (mas[i] > max) {max = mas[i];}
            if (mas[i] < min) {min = mas[i];}
        }
        return (max-min);
    }


    // 5. Создайте функцию, которая принимает три целочисленных аргумента (a, b, c) и возвращает количество целых чисел,
    // имеющих одинаковое значение.
    public static int equal(int a, int b, int c){
        int res=0;
        if (a==b) res+=1;
        if (b==c) res+=1;
        if (a==c) res+=1;
        return res;
    }


    // 6. Создайте метод, который принимает строку в качестве аргумента и возвращает
    // ее в обратном порядке.
    public static String reverseString (String s){
        String s_reverse = "";
        for (int i =  s.length() - 1; i >= 0; i--) {
            char sym = s.charAt(i);
            s_reverse = s_reverse + sym;
        }
        return s_reverse;
    }



    // 7. Вы наняли трех программистов и (надеюсь) платите им. Создайте функцию, которая
    // принимает три числа (почасовая заработная плата каждого программиста) и возвращает разницу между самым
    // высокооплачиваемым программистом и самым низкооплачиваемым.
    public static int programmers (int a, int b, int c){
        int max = a, min = a;
        if (b > max) max = b;
        if (b < min) min = b;
        if (c > max) max = c;
        if (c < min) min =c;
        return (max - min);
    }



    // 8. Создайте функцию, которая принимает строку,
    // проверяет, имеет ли она одинаковое количество x и o и возвращает либо true, либо false.
    //
    //Правила:
    //- Возвращает логическое значение (true или false).
    //- Верните true, если количество x и o одинаковы.
    //- Верните false, если они не одинаковы.
    //- Строка может содержать любой символ.
    //- Если "x" и "o" отсутствуют в строке, верните true.
    public static boolean getXO (String s) {
        int number_o = 0, number_x = 0;
        char[] s_arr = s.toCharArray();
        for (int i = 0; i < s_arr.length; i++){
            if (s_arr[i] == 'o' || s_arr[i] == 'O') number_o ++;
            if (s_arr[i] == 'x' || s_arr[i] == 'X') number_x ++;
        }
        return (number_x == number_o);
    }

    //9. Напишите функцию, которая находит слово "бомба" в данной строке. Ответьте "ПРИГНИСЬ!", если найдешь, в противном случае:"Расслабься, бомбы нет".
    //Примечание:
    //Строка "бомба" может появляться в разных случаях символов (например, в верхнем, нижнем регистре, смешанном).
    public static String bomb (String S) {
        String s = S.toLowerCase();
        String other_s = "bomb";
        if (s.indexOf("bomb") != -1) return "DUCK!";
        else return "Relax, there's no bomb.";
    }

    //10. Возвращает true, если сумма значений ASCII первой строки совпадает с суммой значений ASCII второй строки,
    // в противном случае возвращает false.
    public static boolean sameAscii (String s, String a) {
        char[] s_arr = s.toCharArray();
        char[] a_arr = a.toCharArray();
        int s_sum = 0, a_sum = 0;
        for (int i = 0; i < s_arr.length; i++) s_sum += (int) s_arr[i];
        for (int i = 0; i < a_arr.length; i++) a_sum += (int) a_arr[i];
        return a_sum == s_sum;
    }




}

