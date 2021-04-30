package com.company;

import java.time.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] arr = {"cat", "create", "sat"};
	    //task1
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println("-------------------------");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println("-------------------------");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317) );
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345) );
        System.out.println("------------------------");
        System.out.println(totalPoints(arr, "caster") );
        String[] arr1 = {"trance", "recant"};
        System.out.println(totalPoints(arr1, "recant"));
        String[] arr2 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println(totalPoints(arr2,  "tossed") );
        System.out.println("------------------------");
        int[]run1 = {1, 2, 3, 10, 11, 15};
        int[]run2={5, 4, 2, 1};
        int[] run3 = {3, 5, 7, 10, 15};
        System.out.println(longestRun(run1));
        System.out.println(longestRun(run2));
        System.out.println(longestRun(run3));
        System.out.println("----------------------");
        String[] percents1 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        String[] percents2 = {"10%"};
        String[] percents3 = {"53%", "79%"};
        System.out.println(takeDownAverage(percents1));
        System.out.println(takeDownAverage(percents2));
        System.out.println(takeDownAverage(percents3));
        System.out.println(rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s."));
        System.out.println(rearrange("the4 t3o man5 Happ1iest of6 no7 birt2hday steel8!"));
        System.out.println(rearrange("is2 Thi1s T4est 3a"));
        System.out.println(rearrange("4of Fo1r pe6ople g3ood th5e the2"));
        System.out.println(rearrange(" "));
        System.out.println("--------------------");
        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(maxPossible(8732, 91255));
        System.out.println("--------------------");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra") );
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome") );
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println("--------------------");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123) );

    }


    //5.1
    public static boolean sameLetterPattern(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        int dif = str1.charAt(0)-str2.charAt(0);
        for (int i=0;i<str1.length();++i) {
            if(str1.charAt(i)-str2.charAt(i)!=dif)
                return false;
        }
        return true;
    }

    //5.2
    public static String spiderVsFly(String str1, String str2) {
        number2 spider = new number2(str1.charAt(0),Integer.parseInt(Character.toString(str1.charAt(1))));
        number2 fly = new number2(str2.charAt(0),Integer.parseInt(Character.toString(str2.charAt(1))));
        number2.result=spider.getLetter()+Integer.toString(spider.getLevel());
        int distance=spider.getDistanceAndDir(fly)[0],dir=spider.getDistanceAndDir(fly)[1];
        if(spider.getLevel()==0)
            spider.setLetter(fly.getLetterChar());
        if(fly.getLevel()==0)
            fly.setLetter(spider.getLetterChar());
        if(spider.getLevel()> fly.getLevel() || distance > 2) { //h4 b3
            while(spider.getLevel()>fly.getLevel()) {
                spider.changeLevel(-1);
            }
            if(distance>2) {
                while(spider.getLevel()!=0) {
                    if(spider.getLevel()==1)
                        spider.setLetter('A');
                    spider.changeLevel(-1);
                }
                spider.setLetter(fly.getLetterChar());
                while(spider.getLevel()!=fly.getLevel()) {
                    spider.changeLevel(1);
                }
            }else {
                while(spider.getLetterChar()!=fly.getLetterChar()) {
                    spider.changeLetter(dir);
                }
            }
        }
        else {
            while(spider.getLetterChar()!=fly.getLetterChar()) {
                spider.changeLetter(dir);
            }
            while(spider.getLevel()!=fly.getLevel()) {
                spider.changeLevel(1);
            }
        }
        return number2.result;
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
    public static int longestRun(int[] arr) {
        int current=1, longest=1;
        for (int i=1;i<arr.length;i++) {
            if(arr[i]-1==arr[i-1] || arr[i]+1==arr[i-1]) {
                current++;
            }
            else {
                if(current>longest)
                    longest=current;
                current =1;
            }
        }
        if(current>longest)
            longest=current;
        return longest;
    }

    //5.6
    public static String takeDownAverage(String[] percents) {
        int sum = 0;
        for (int i = 0; i < percents.length; i ++) {
            int rate = Integer.parseInt(percents[i].substring(0,percents[i].length()-1));
            sum +=rate;
        }
        double avg = sum / (double) percents.length;
        double newAvg = avg - 5;
        return Integer.toString((int) Math.round(newAvg * (percents.length + 1) - sum))+"%";
    }


    //5.7
    public static String rearrange(String s){
        String[] words = s.split(" ");
        String[] result = new String[words.length];
        for (String word: words){
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++){
                if ('0'<chars[i] && chars[i] <'9') {
                    int index = Integer.parseInt(Character.toString(chars[i]));
                    chars[i] = ' ';
                    String newWord = new String(chars);
                    result[index - 1] = newWord.replace(" ", "");
                }
            }
        }
        return String.join(" ", result);
    }

    //5.8
    public static int maxPossible(int a, int b){
        ArrayList<Integer> digits1 = new ArrayList<Integer>();
        ArrayList<Integer> digits2 = new ArrayList<Integer>();
        int num = new Integer(b);
        while (num > 0 ) {
            digits2.add(num%10);
            num/=10;
        }

        num = new Integer(a);
        while (num > 0 ) {
            digits1.add(num%10);
            num/=10;
        }

        Collections.sort(digits2, Collections.reverseOrder());
        Collections.reverse(digits1);

        for (int i = 0; i < digits1.size(); i ++) {
            if (digits2.get(0)>digits1.get(i)){
                digits1.set(i, digits2.get(0));
                digits2.remove(0);
            }
            if (digits2.isEmpty()) break;
        }

        int result = 0;
        for (int i = digits1.size()-1; i >= 0; i--) {
            result += digits1.get(i) * (int) Math.pow(10, digits1.size()-1-i);
        }
        return result;
    }


    //5.9
    public static String timeDifference(String name1,String time1, String name2) {
        String[] arr = time1.split(" ");
        String mon="";
        if(arr[0].equals("December"))
            mon="12";
        if(arr[0].equals("November"))
            mon="11";
        if(arr[0].equals("October"))
            mon="10";
        if(arr[0].equals("September"))
            mon="9";
        if(arr[0].equals("August"))
            mon="8";
        if(arr[0].equals("July"))
            mon="7";
        if(arr[0].equals("June"))
            mon="6";
        if(arr[0].equals("May"))
            mon="5";
        if(arr[0].equals("April"))
            mon="4";
        if(arr[0].equals("March"))
            mon="3";
        if(arr[0].equals("February"))
            mon="2";
        if(arr[0].equals("Jenuary"))
            mon="1";
        String days =arr[1].substring(0,arr[1].length()-1);
        if(mon.length()==1)
            mon="0"+mon;
        if(days.length()==1)
            days="0"+days;
        String timezone="";
        int h=0,m=0;
        switch (name2) {
            case "Los Angeles":{
                timezone="-08:00";
                h=-8;
                break;
            }
            case "New York":{
                timezone="-05:00";
                h=-5;
                break;
            }
            case "Caracas":{
                timezone="-04:30";
                h=-4;
                m=-30;
                break;
            }
            case "Buenos Aires":{
                h=-3;
                timezone="-03:00";
                break;
            }
            case "London":{
                timezone="+00:00";
                break;
            }
            case "Rome":{
                h=1;
                timezone="+01:00";
                break;
            }
            case "Moscow":{

                h=3;
                timezone="+03:00";
                break;
            }
            case "Tehran":{
                h=3;
                m=30;
                timezone="+03:30";
                break;
            }
            case "New Delphi":{
                h=5;
                m=30;
                timezone="+05:30";
                break;
            }
            case "Beijing":{
                h=8;
                timezone="+08:00";
                break;
            }
            case "Canberra":{
                h=10;
                timezone="+10:00";
                break;
            }
        }
        switch (name1) {
            case "Los Angeles":{
                timezone="-08:00";
                h+=8;
                break;
            }
            case "New York":{
                h+=5;

                timezone="-05:00";
                break;
            }
            case "Caracas":{
                timezone="-04:30";
                h+=4;
                m+=30;
                break;

            }
            case "Buenos Aires":{
                timezone="-03:00";
                h+=3;
                break;
            }
            case "London":{
                timezone="+00:00";
                break;
            }
            case "Rome":{
                timezone="+01:00";
                h-=1;
                break;
            }
            case "Moscow":{
                timezone="+03:00";
                h-=3;
                break;
            }
            case "Tehran":{
                h-=3;
                m-=30;
                timezone="+03:30";
                break;
            }
            case "New Delphi":{
                timezone="+05:30";
                h-=5;
                m-=30;
                break;
            }
            case "Beijing":{
                h-=8;
                timezone="+08:00";
                break;
            }
            case "Canberra":{
                timezone="+10:00";
                h-=10;
                break;
            }
        }
        ZonedDateTime a = ZonedDateTime.parse(arr[2]+"-"+mon+"-"+days+"T"+arr[3]+timezone);
        int totalMin=h*60+m;
        if(totalMin<0)
            a=a.minusMinutes(-totalMin);
        else
            a=a.plusMinutes(totalMin);
        return a.toString();

    }


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

class number2 {
    private char letter;
    private int level;
    public static String result;

    public number2 (char letter, int level){
        this.letter = letter;
        this.level = level;
    }

    @Override
    public String toString(){
        return Character.toString(letter)+Integer.toString(level);
    }

    public String getLetter() {
        return Character.toString(letter);
    }
    public char getLetterChar() {
        return letter;
    }
    public int getLevel() {
        return level;
    }

    public void changeLetter(int dir) {
        letter+=dir;
        if(letter-'A'>7)
            letter-=8;
        if(letter-'A'<0)
            letter+=8;
        result+="-"+this.toString();
    }

    public void setLetter(char ch) {
        if (ch<='H' && ch>='A') {
            letter=ch;
        }
    }

    public void changeLevel(int fromTo) {// -1 in    1 out
        level+=fromTo;

        result+="-"+this.toString();
    }

    public int[] getDistanceAndDir(number2 dot) {
        int distance=this.getLetterChar()-dot.getLetterChar() ,dir;
        if(distance>0) {
            if(distance<=4) {
                dir = -1;
            }
            else {
                dir = 1;
                distance=8-distance;
            }
        }
        else {
            if(-distance<=4) {
                distance*=-1;
                dir =1;
            }
            else {
                dir=-1;
                distance = distance+8;
            }
        }
        return new int[] {distance,dir};
    }
}

