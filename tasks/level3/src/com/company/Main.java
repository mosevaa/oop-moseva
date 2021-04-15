package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Object[][] array ={{"Nice", 942208},{"Abu Dhabi", 1482816},{"Naples", 2186853},{"Vatican City", 572}};
        array = millionsRounding(array);
        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array[i].length; j ++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.print("\n");
        }
    }



    //task 1
    public static Object[][] millionsRounding (Object[][] array){
        for (int i = 0; i < array.length; i++) {
            array[i][1] = Math.round((double)(int)array[i][1]/1000000)*1000000;
        }
    return array;
    }


    //task2
    public static double[] otherSides (int a) {
        double[] res = {a*2, a*Math.sqrt(3)};
        return res;
    }



    //task 3
    public static String rps (String first, String second) {
        if (first == second) return "TIE";
        if ((first == "rock" && second == "scissors") || (first == "paper" && second == "rock") || (first == "scissors" && second == "paper")) return "Player 1 wins";
        else return "Player 2 wins";
    }

    //task4
    public static int warOfNumbers(int[] numbers) {
        int sum_ch = 0;
        int sum_n = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] % 2 ==0) sum_ch +=numbers[i];
            else sum_n += numbers[i];
        }
        return Math.abs(sum_ch - sum_n);
    }

    //task5
    public static String reverseCase (String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length; i ++) {
            if (Character.isUpperCase(chars[i])) chars[i] = Character.toLowerCase(chars[i]);
            else chars[i] = Character.toUpperCase(chars[i]);
        }
        String result = new String (chars);
        return result;
    }
    //task6
    public static String inatorInator (String s) {
        char [] gl = {'a','e','i','o', 'u', 'y'};
        boolean last = false;
        for (char c:gl) {
            if (c == s.toCharArray()[s.length()-1]) {
                last = true;
            }
        }
        if (last)
            return s + "-inator " + s.length() +"000";
        else
            return s + "inator " + s.length() + "000";
    }

    //task7
    public static boolean doesBrickFit (int a, int b, int c, int w, int h) {
        return (w-a>=0 && h - b >=0)||(w-b>=0 && h-a>=0)||(w-c>=0 &&  h-a>=0)||(w-a>=0 && h-c>=0)||(w-b>=0 && w-c>=0)||(w-c>=0 && w-b >=0);
    }


    //task8
    public static double totalDistance(double lit, double ras, int pas, boolean bool) {
        if (pas > 1) {
            for (int i = 1; i <pas; i ++) {
                ras = ras * 1.05;
            }
        }
        if (bool) {
            ras *= 1.1;
        }
        return (double) lit / ras*100;
    }

    //task9
    public static double mean (int[] a){
        int sum = 0;
        int k = 0;
        for (int i = 0; i <a.length; i ++) {
            sum += a[i];
        }
        return ((double) sum/a.length);
    }

    //task10
    public static boolean parityAnalysis(int a) {
        int sum = 0;
        int n = a;
        while(n != 0){
            sum += (n % 10);
            n/=10;
        }
        return ((a % 2 == 0 ) && (sum % 2 == 0))||((a % 2 != 0) && (sum % 2 != 0));
    }
}
