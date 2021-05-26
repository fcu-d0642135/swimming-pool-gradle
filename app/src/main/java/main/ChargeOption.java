package main;

import java.util.Scanner;

public class ChargeOption {
    public static String select() {
        System.out.println(Chinese.planSelection);
        Scanner input = new Scanner(System.in);
        return input.next();
    }
}

