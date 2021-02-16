/*Создайте функцию, которая принимает три аргумента prob, prize, pay и возвращает true, если
 prob * prize > pay; в противном случае возвращает false.
 */




package com.company;

public class task8 {
    public static boolean profitableGamble(float prob, float prize, float pay) {
        return (prob * prize > pay);
    }
}
