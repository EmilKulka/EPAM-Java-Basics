package com.epam.rd.autotasks.sequence;
import java.util.ArrayList;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        Scanner scanner = new Scanner(System.in);

        int currentMax = scanner.nextInt();

        while(true) {
            int currentInput = scanner.nextInt();
            if(currentInput == 0) {
                break;
            }
            if(currentMax < currentInput) {
                currentMax = currentInput;
            }
        }

        return currentMax;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
