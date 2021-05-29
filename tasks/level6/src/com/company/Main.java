package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.",
                "sworn love lived"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println("-------------------------------------");

        // collect
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));
        System.out.println("-------------------------------------");

        // nicoCipher
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println("-------------------------------------");

        // twoProduct
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15, 3}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));
        System.out.println("-------------------------------------");

        // isExact
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));
        System.out.println("-------------------------------------");

        // fractions
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println("-------------------------------------");

        // pilish
        System.out.println(pilish("33314444"));
        System.out.println(pilish("TOP"));
        System.out.println(pilish("X"));
        System.out.println(pilish(""));
        System.out.println("-------------------------------------");

        // generateNonconsecutive
        System.out.println(generateNonconsecutive(1));
        System.out.println(generateNonconsecutive(2));
        System.out.println(generateNonconsecutive(3));
        System.out.println(generateNonconsecutive(4));
        System.out.println("-------------------------------------");

        // isValid
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println("-------------------------------------");

        // sumsUp
        System.out.println(sumsUp(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(sumsUp(new int[] { 1, 2, 3, 7, 9 }));
        System.out.println(sumsUp(new int[] { 10, 9, 7, 2, 8 }));
        System.out.println(sumsUp(new int[] { 1, 6, 5, 4, 8, 2, 3, 7 }));















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
public static String nicoCipher(String message, String key) {
    ArrayList<Character> chars = new ArrayList<>();
    for (char c : key.toCharArray()) {
        chars.add(c);
    }

    HashMap<Character, ArrayList<Character>> data = new HashMap<>();
    int counter = 0;
    while (!message.equals("")) {
        counter += 1;
        for (Character chr : chars){
            if (message.equals("")){
                data.get(chr).add(' ');
            } else if (!data.containsKey(chr)) {
                data.put(chr, new ArrayList<>());
                data.get(chr).add(message.charAt(0));
            } else {
                data.get(chr).add(message.charAt(0));
            }

            if (message.length() == 1){
                message = "";
            } else if (message.length() > 1) {
                message = message.substring(1);
            }
        }
    }
    Collections.sort(chars);

    String result = "";
    for (int i = 0; i < counter; i++){
        for (Character chr: chars){
            result += data.get(chr).get(0);
            data.get(chr).remove(0);
        }
    }
    return result;
}


//6.4
    public static int[] twoProduct(int[] arr, int val) {
        int first=0,second=0;
        int[] answer = new int[2];
        for(int i=arr.length-1;i>0;i--) {
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
    public static int[] isExact(int val){
        int[]answer=new int[0];
        int number = isFract(val,2);
        if (number != -1){
            answer = new int[]{val,number};
        }
        return answer;
    }
    public static int isFract(int val,int k){
        if (val == 1) return k-1;
        if (val%k!=0) return -1;
        return isFract(val/k,k+1);
    }

//6.6
public static String fractions(String numb) {
    String noSmiles="",withoutDotOnly="";
    int power1=0,power2=0,dotIndex=0,firstIndex=0,secondIndex=0;
    for (int i=0;i<numb.length();i++) {
        if(numb.charAt(i)=='.') {
            dotIndex=i;
        }else
        if(numb.charAt(i)=='(') {
            firstIndex=i;
        }else
        if(numb.charAt(i)==')')
            secondIndex=i;
        else
            noSmiles+=numb.charAt(i);
    }
    withoutDotOnly=noSmiles.substring(0,firstIndex-1);
    int firstNumber,secondNumber;
    power1=secondIndex-dotIndex-2;
    power2=firstIndex-dotIndex-1;
    firstNumber=(int)(Math.pow(10, power1)-Math.pow(10, power2));
    secondNumber=Integer.parseInt(noSmiles)-Integer.parseInt(withoutDotOnly);
    int[] pair=divide(secondNumber,firstNumber);
    return pair[0]+"/"+ pair[1];
}
    public static int[] divide(int a, int b) {
        int k=2;
        int t =Math.max(a, b);
        while (k<t) {
            if(a%k==0 && b%k==0) {
                a/=k;
                b/=k;
            }else
                k++;
        }
        return new int[] {a,b};
    }
//6.7
public static String pilish(String str) {
        if (str == "") return "";
    String st="314159265358979";
    String res="";
    int index=0;
    int len=0;
    for (int i=0;i<str.length();i++) {
        len++;
        res+=str.charAt(i);
        if(st.charAt(index)-'0'==len)
        {
            res+=" ";
            len=0;
            index++;
        }
        if(index==15)
            return res;
    }
    if(st.charAt(index)-'0'>len)
        while(st.charAt(index)-'0'>len) {
            res+=res.charAt(res.length()-1);
            len++;
        }
    return res;
}

//6.8
public static String generateNonconsecutive(int n) {
    String result = "";
    for (int i = 0; i < Math.pow(2, n); i++){
        String binary = Integer.toBinaryString(i);
        if (!binary.contains("11")){
            while (binary.length() < n){
                binary = "0" + binary;
            }
            result += binary;
            result += " ";
        }
    }
    return result;
    }


//6.9
public static String isValid(String s){
    Map<String, Integer> dictionary = new HashMap<String, Integer>();
    for (int i=0; i< s.length(); i++){
        String sym = s.substring(i, i+1);
        if (dictionary.keySet().contains(sym)){
            int old = dictionary.get(sym);
            dictionary.replace(sym, old, old+1);
        }
        else{
            dictionary.put(sym, 1);
        }
    }
    int count = 0;
    int sum = 0;
    int mis = 0;
    String ans = "YES";
    for (int value: dictionary.values()){
        if (count != 0 && Math.abs(sum / count - value) > 1 ){
            ans = "NO";
            break;
        }
        sum+= value;
        count++;
        if ( (double) sum/ count != sum / count){
            mis++;
            sum -= value;
            count--;
            if (mis > 1){
                ans = "NO";
                break;
            }
        }
    }
    return ans;
}

//6.10
public static List<List<Integer>> sumsUp(int[] input) {
    List<List<Integer>> pairs = new ArrayList<>();

    for (int i = input.length - 1; i >= 0; i--) {
        for (int j = i; j >= 0; j--) {
            if (j != i && (input[i] + input[j]) == 8) {
                List<Integer> pair = new ArrayList<>(List.of(input[i], 8 - input[i]));
                pair.sort(Integer::compare);
                pairs.add(pair);
            }
        }
    }

    Collections.reverse(pairs);
    return pairs;
}
}


