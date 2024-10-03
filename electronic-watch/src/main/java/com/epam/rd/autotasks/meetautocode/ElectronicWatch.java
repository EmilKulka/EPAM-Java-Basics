package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputSeconds = scanner.nextInt();

        int hours = (inputSeconds / 3600) % 24;
        int minutes = (inputSeconds / 60) % 60;
        int seconds = inputSeconds % 60;

        System.out.printf("%d:%02d:%02d",
                hours,
                minutes,
                seconds
        );


    }
}
