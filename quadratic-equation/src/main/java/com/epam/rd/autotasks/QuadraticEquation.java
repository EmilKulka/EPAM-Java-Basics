package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double delta = Math.pow(b,2) - (4 * a * c);

        if(delta < 0) {
            System.out.println("no roots");
        }
        else if (delta == 0) {
            System.out.println((-b) / (2 * a));
        }
        else {
            double x1 = (((-b) - Math.sqrt(delta)) / (2 * a));
            double x2 = (((-b) + Math.sqrt(delta)) / (2 * a));
            System.out.println(x1 + " " + x2);
        }



    }

}