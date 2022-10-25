package com.simplon.marjane.utils;

import java.util.Scanner;

public class MainUtils {

    static Scanner scan = new Scanner(System.in);

    public static void  println(String text) {
        System.out.println(text);
    }
    public static void  print(String text) {
        System.out.print(text);
    }
    public static Scanner getScanner() {
        return scan;
    }
}
