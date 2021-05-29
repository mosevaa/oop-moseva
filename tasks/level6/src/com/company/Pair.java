package com.company;

import java.util.List;

public class Pair {
    public int value;
    public List<Character> list;
    public Pair(int val, List<Character> list) {
        value =val;
        this.list = list;
    }
    public boolean comparator(Pair pair) {
        return pair.value>value;
    }
}
