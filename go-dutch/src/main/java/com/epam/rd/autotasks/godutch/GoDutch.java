package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner scanner = new Scanner(System.in);

        double billIncludingTip = scanner.nextInt() * 1.1;

        int numberOfFriends = scanner.nextInt();

        if (billIncludingTip < 0) {
            System.out.println("Bill total amount cannot be negative");
        } else if (numberOfFriends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            System.out.println((int) billIncludingTip / numberOfFriends);
        }
    }
}
