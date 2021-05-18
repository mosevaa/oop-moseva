package com.company;

import java.util.LinkedList;


public class URLPool {
    LinkedList<URLDepthPair> viewedLinks;
    LinkedList<URLDepthPair> foundLink;
    int maxDepth;
    int cWait;

    public URLPool(int maxDepth){
        this.maxDepth = maxDepth;
        foundLink = new LinkedList<URLDepthPair>();
        viewedLinks = new LinkedList<URLDepthPair>();
        cWait = 0;
    }

    public synchronized URLDepthPair getPair(){
        while(foundLink.size() == 0){
            cWait++;
            try{
                wait();
            }
            catch (InterruptedException e){
                System.out.println("Ignoring Interrupted Exception");
            }
            cWait--;
        }
        URLDepthPair current = foundLink.removeFirst();
        return current;
    }

    public synchronized void addPair(URLDepthPair pair){
        if(URLDepthPair.check(viewedLinks,pair)){
            viewedLinks.add(pair);
            if (pair.getDepth()<maxDepth){
                foundLink.add(pair);
                notify();
            }
        }
    }

    public int getWait() {
        return cWait;
    }


    public LinkedList<URLDepthPair> getViewedLinks(){
        return viewedLinks;
    }
}
