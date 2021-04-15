package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	int[] array = {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5};
	System.out.print(code(7977));
    }

    //task1
    public static String sevenBoom (int[] a){
        for (int n: a) {
            while (n > 0) {
                if (n % 10 == 7) return "Boom!";
                n /= 10;
            }
        }
        return "there is no 7 in the array";
    }

    //task2
    public static boolean cons (int[] ar) {
        Arrays.sort(ar);
        for (int i = 0; i < ar.length-1; i ++) {
            if (ar[i+1]-ar[i]!=1) return false;
        }
        return true;
    }

    //task3
    public static String unmix(String s){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i+=2) {
            if (i+1 == s.length()) {
                result.append(s.charAt(i));
            }
            else {
                result.append(s.charAt(i+1));
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
    //task4
    public static String noYelling (String s) {
        int i = s.length()-1;
        while ((s.charAt(i) == '!' || s.charAt(i) == '?') && (i!=0) && (s.charAt(i-1)=='!' || s.charAt(i-1) =='?')){
            s=s.substring(0,i);
            i-=1;
        }
        return s;
    }
    //task5
    public static String xPronounce (String s){
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i ++){
            if (str[i].equals("x"))
            {str[i] = "ecks";}
            if (str[i].substring(0) == "x")
            {str[i] = str[i].replace("x","z");}
            if (str[i].contains("x"))
            {str[i] = str[i].replace("x", "cks");}
        }
        return String.join(" ", str);
    }
    //task6
    public static int largestGap(int[] ar){
        Arrays.sort(ar);
        int largest=0;
        for (int i = 0; i < ar.length - 1; i ++){
            if (ar[i+1] - ar[i] > largest) largest = ar[i+1] - ar[i];
        }
        return largest;
    }

    //task7
    public static int code (int n){
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while (n > 0 ) {
            digits.add(n%10);
            n/=10;
        }
        digits.sort(Collections.reverseOrder());

        int newNum = 0;
        for (int i = 0; i < digits.size(); i++) {
            newNum += digits.get(i) * (int) Math.pow(10, i);
        }
        if (n-newNum > 0) return (n-newNum);
        else return 0;
    }

    //task8
    public static String commonLastVowel (String s) {
        int newValue,max = 0;
        String result = "";
        Map<Character,Integer> common = new HashMap<Character,Integer>();
        String[] words = s.toLowerCase().split(" ");
        List<Character> vowel = Arrays.asList('e','y','u','i','o','a');
        for (String word:words){
            for (int i = word.length(); i >= 0; i--){
                if (vowel.contains(word.charAt(i))){
                    if (common.containsKey(word.charAt(i))) {
                        newValue = common.get(word.charAt(i))+1;
                    }
                    else {
                        newValue = 1;
                    }
                    common.put(word.charAt(i), newValue);
                    break;
                }
            }
        }
        for (Map.Entry<Character,Integer> entry : common.entrySet()){
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey().toString();
            }
        }
        return result;
    }

    //task9
    public static int memeSum (int a, int b){
        StringBuilder result = new StringBuilder();
        while (a % 10 != 0 || b % 10 != 0) {
            int c = a % 10 + b % 10;
            result.insert(0, c);
            a/=10;
            b/=10;
        }
        return(Integer.parseInt(result.toString()));
    }

    //task10
    public static String unrepeated ( String s) {
        ArrayList<Character> chars = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (!chars.contains(c)) {
                chars.add(c);
                result.append(c);
            }
        }
        return result.toString();
    }
}
