package com.company;

import java.io.IOException;
import java.net.*;
import java.util.LinkedList;

public class Crawler {


    static LinkedList<URLDepthPair> findLink = new LinkedList<URLDepthPair>();
    static LinkedList<URLDepthPair> viewedLink = new LinkedList<URLDepthPair>();

    public static void start(String pair, int maxDepth) throws IOException{
        findLink.add(new URLDepthPair(pair,0));
        while (!findLink.isEmpty()) {
            URLDepthPair current = findLink.removeFirst();
            if (current.getDepth()<maxDepth) {
                Socket my_socket = new Socket(current.getHost(), 80);
                my_socket.setSoTimeout(1000);
                try{
                    //
                }catch (SocketTimeoutException e){
                    my_socket.close();
                }

            }
        }
    }
    public static void main(String[] args) {
	// write your code here
    String arg[] = new String[]{"",""};

        
    }
}
