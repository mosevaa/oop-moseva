package com.company;

public class Primes {
    //вывод простых чисел
    public static void main(String[] args) {
	    for (int i = 2; i < 101; i++){
	        if (isPrimes(i)) {
	            System.out.print(i + " ");
            }
        }
    }
    //определяет, является ли число простым
    public static boolean isPrimes (int n){
        for (int i=2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
