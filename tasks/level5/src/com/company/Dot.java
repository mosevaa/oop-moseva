package com.company;

public class Dot {
    private char letter;
    private int level;
    public static String route;

    public Dot (char letter, int level){
        this.letter = letter;
        this.level = level;
    }

    @Override
    public String toString(){
        return Character.toString(letter)+Integer.toString(level);
    }

    public String getLetterString() {
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
        route+="-"+this.toString();
    }

    public void setLetter(char ch) {
        if (ch<='H' && ch>='A') {
            letter=ch;
        }
    }

    public void changeLevel(int fromTo) {// -1 in    1 out
        level+=fromTo;

        route+="-"+this.toString();
    }

    public int[] getDistanceAndDir(Dot dot) {
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
