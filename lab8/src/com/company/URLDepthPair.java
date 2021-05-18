package com.company;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

//класс, который хранит url и глубину, на которой находится этот сайт
public class URLDepthPair {
    //поддерживаемый протокол
    public final static String URL_PREFIX = "http://";
    //url адрес
    public String url;
    //глубина, на которой находится url
    public int depth;

    public URLDepthPair (String url, int depth) {
        this.url = url;
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    public String getUrl() {
        return url;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() throws MalformedURLException {
        URL host = new URL(url);
        return host.getHost();
    }
    public String getPath() throws MalformedURLException {
        URL path = new URL(url);
        return path.getPath();
    }

    @Override
    public String toString() {
        return "URLDepthPair{" +
                "url='" + url + '\'' +
                ", depth=" + depth +
                '}';
    }

    public static boolean check(LinkedList<URLDepthPair> resultLink, URLDepthPair pair) {
        boolean isAlready = true;
        for (URLDepthPair c : resultLink)
            if (c.getUrl().equals(pair.getUrl()))
                isAlready=false;
        return isAlready;
    }
}

