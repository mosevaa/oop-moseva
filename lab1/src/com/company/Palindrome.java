package com.company;

public class Palindrome {
    public static void main (String[] args){
        String[] s = {"java", "Palindrome", "madam", "racecar", "apple", "kayak", "song", "noon"};
        for (int i = 0; i < s.length; i++){
            String check = s[i];
            System.out.println (s[i] + " " + isPalindrome(check));
        }
    }

    //переворот строки
    public static String reverseString (String s){
        String s_reverse = "";
        for (int i =  s.length() - 1; i >= 0; i--) {
            char sym = s.charAt(i);
            s_reverse = s_reverse + sym;
        }
        return s_reverse;
    }

    //является ли строка палиндромом
    public static boolean isPalindrome (String s) {
        String reverse = reverseString(s);
        return reverse.equals((s));
    }
}
