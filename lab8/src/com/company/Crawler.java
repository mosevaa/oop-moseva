package com.company;

import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class Crawler {


    public static void showResult(LinkedList<URLDepthPair> list){
        for (URLDepthPair c:list){
            System.out.println("Depth : "+c.getDepth() + "\tLink : "+c.getUrl());
        }
    }

    public static boolean checkDigit(String a){
        boolean isDigit = true;
        for (int i = 0; i < a.length(); i ++){
            isDigit = Character.isDigit(a.charAt(i));
        }
        return isDigit;
    }

    public static void main(String[] args) {
        // write your code here
        String[] arg = new String[]{"http://government.ru/","2", "3"};
        if ((arg.length == 3) && checkDigit(arg[1])&&checkDigit(arg[2])) {
            String url = arg[0];
            int maxDepth = Integer.parseInt(arg[1]);
            int numThreads = Integer.parseInt(arg[2]);
            URLPool pool = new URLPool(maxDepth);
            pool.addPair(new URLDepthPair(url,0));
            for(int i = 0; i < numThreads; i ++){
                CrawlerTask c = new CrawlerTask(pool);
                Thread t = new Thread(c);
                t.start();
            }
            while(numThreads != pool.getWait()){
                try{
                    Thread.sleep(500);
                }
                catch (InterruptedException e){}
            }
            try{
                showResult(pool.getViewedLinks());
            }
            catch(NullPointerException e){
                System.out.println("No Links");
            }
            System.exit(0);

        }
        else System.out.println("usage: java Crawler <URL> <maximum_depth> <num_threads>");
    }
}




