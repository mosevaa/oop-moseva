package com.company;

import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
    }


    //6.1
    public static String hiddenAnagram(String str, String str2) {
        StringBuilder result = new StringBuilder();
        str = str.toLowerCase();
        String[] arr = {".", "!", "?", " ", ",", ";"};
        for (String s : arr) {
            str = str.replace(s, "");
            str2 = str2.replace(s, "");
        }
        for (int i = 0; i < str.length(); i++) {
            String chr = Character.toString(str.charAt(i));
            if (str2.contains(chr)) {
                result.append(chr);
                str2 = str2.replaceFirst(chr, "");
            }
            if(str2.isEmpty()) break;
        }
        for (int i = 0; i < str2.length(); i ++){
            String chr = Character.toString(str2.charAt(i));
            if(!result.toString().contains(chr)){return"noutfond";}
        }
        return result.toString();
    }

//6.2
    public static String[] collect(String str, int n){
        int collectionSize = str.length()/n;
        String[]result = new String[collectionSize];
        for (int i = 0; i < result.length; i ++) {
            result[i] = str.substring(i*n,i*n+n);
        }
        Arrays.sort(result);
        return(result);
    }
//6.3

//6.4
    public static int[] twoProduct(int[] arr, int val) {
        int first=0,second=0;
        int[] answer = new int[2];
        for(int i=arr.length-1;i>0;--i) {
            second=arr[i];
            for(int j=i-1;j>=0;--j) {
                first=arr[j];
                if(first*second==val) {
                    answer[0]=first;
                    answer[1]=second;
                 }
            }
        }
        return answer;
}

//6.5

//6.6

//6.7

//6.8

//6.9

//6.10

}