package com.assignment.Defense.of.the.Ancients2.controller;

import java.util.Scanner;

public class FebSeries {
    static int sum;
    static int a = 0;
    static int b = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(a+"    ");
        System.out.print(b+"    ");
        printFebSeries(n-2);   // 10;
    }


    public static void printFebSeries(int num){    // 8

        if(num<=0)
            return;

        sum = a+b;
        System.out.print(sum+"   ");
        a = b;
        b = sum;
        printFebSeries(num-1);
    }
}
