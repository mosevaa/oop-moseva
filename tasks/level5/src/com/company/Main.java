package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        String[] arr = {"cat", "create", "sat"};
	    System.out.println (sameLetterPattern("FFFF", "ABCD"));
	    System.out.println(digitsCount(1000));
	    System.out.println(totalPoints(arr, "caster"));
	    System.out.println(isNew(321));
    }


    //5.1
    public static boolean sameLetterPattern(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        int gap = 0;
        gap = str1.charAt(0) - str2.charAt(0);
        for (int i = 1; i < str1.toCharArray().length; i++) {
            if (str1.charAt(0) - str2.charAt(0) != gap) return false;
        }
        return true;
    }

    //5.3
    public static int digitsCount (int num) {
        if (num >= 10) return 1 + digitsCount(num / 10);
        return 1;
    }

    //5.4
    public static int totalPoints (String[] words, String rightWord) {
        int points = 0;
        for (String word: words){
            boolean isRight = true;
            String wordForTest = rightWord;
            for (int i=0; i < word.length(); i++){
                String chr = Character.toString(word.charAt(i));
                if (wordForTest.contains(chr)){
                    wordForTest = wordForTest.replace(chr, "");
                }
                else{
                    isRight = false;
                    break;
                }
            }
            if (isRight){
                points += word.length() - 2;
                if (word.length() == 6){
                    points += 50;
                }
            }
        }

        return points;
    }

    //5.5
    public static int longestRun(int[] numbers){
        return 0;
    }

    //5.6
    public static int takeDownAverage(int[] percents) {
        int sum = 0;
        for (int i = 0; i < percents.length; i ++) {
            sum += percents[i];
        }
        double avg = sum / (double) percents.length;
        double newAvg = avg - 5;
        return (int) Math.round(newAvg * (percents.length + 1) - sum);
    }


    //5.7


    //5.8


    //5.9



    //5.10
    public static boolean isNew (int n) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        int num = new Integer(n);
        while (n > 0 ) {
            digits.add(n%10);
            n/=10;
        }
        Collections.sort(digits);

        int newNum = 0;
        for (int i = digits.size()-1; i >= 0; i--) {
            newNum += digits.get(i) * (int) Math.pow(10, 2-i);
        }

        if (num > newNum) return false;
        return true;
    }
}
