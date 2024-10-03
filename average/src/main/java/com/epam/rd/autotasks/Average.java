package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int numbersCount = 0;

        while(true) {
            int currentNumber = scanner.nextInt();
            if(currentNumber == 0) {
                System.out.println(sum / numbersCount);
                break;
            }
            sum += currentNumber;
            numbersCount++;
        }

    }

}