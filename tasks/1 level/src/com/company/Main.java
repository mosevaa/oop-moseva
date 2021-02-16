//TODO:
// 1) создать сканер номера задач
// 2) сделать ввод начальных данных для каждой задачи

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a,b,c;
        System.out.println ("Введите номер задачи (от 1 до 10) и 0 для выхода");
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        while (n!=0) {
            switch (n){
                case (1):
                    System.out.println("Введите число: ");
                    a = scanner.nextInt();
                    System.out.println(task1.convert(a));
                    break;
                case (2):
                    System.out.println("Введите числa: ");
                    a = scanner.nextInt();
                    b=scanner.nextInt();
                    System.out.println(task2.points(a,b));
                    break;
                case (3):
                    System.out.println("Введите числa: ");
                    a = scanner.nextInt();
                    b=scanner.nextInt();
                    c=scanner.nextInt();
                    System.out.println(task3.footballPoints(a,b,c));
                    break;
                case(4):
                    System.out.println("Введите числo: ");
                    a = scanner.nextInt();
                    System.out.println(task4.divisibleByFive(a));
                    break;
                case(5):
                    System.out.println("Введите true или false: ");
                    boolean alog = scanner.nextBoolean();
                    boolean blog = scanner.nextBoolean();
                    System.out.println(task5.and(alog ,blog ));
                    break;
                case(6):
                    System.out.println("Введите числa: ");
                    a = scanner.nextInt();
                    b=scanner.nextInt();
                    c=scanner.nextInt();
                    System.out.println(task6.howManyWalls(a,b,c));
                    break;
                case(7):
                    System.out.println("Введите число: ");
                    a = scanner.nextInt();
                    System.out.println(task7.squared(a));
                    break;
                case(8):
                    System.out.println("Введите числa: ");
                    float a1 = scanner.nextFloat();
                    float b1 = scanner.nextFloat();
                    float c1 = scanner.nextFloat();
                    System.out.println(task8.profitableGamble(a1,b1,c1));
                    break;
                case(9):
                    System.out.println("Введите числa: ");
                    a = scanner.nextInt();
                    b=scanner.nextInt();
                    System.out.println(task9.frames(a,b));
                    break;
                case(10):
                    System.out.println("Введите числa: ");
                    a = scanner.nextInt();
                    b=scanner.nextInt();
                    System.out.println(task10.mod(a,b));
                    break;
                default:
                    System.out.println("Try something else(1<=n<=10)");
                }
            System.out.println ("Введите номер задачи (от 1 до 10) и 0 для выхода");
            n=scanner.nextInt();

            }
        }


}
