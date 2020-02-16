package com.Lisa;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Principal:");
        int principle = scanner.nextInt();
        System.out.println("Annual Interest Rate:");
        double rate = scanner.nextDouble() / 100;
        System.out.println("Period (Years):");
        int period = scanner.nextInt();
        double origMort = principle * ((rate * Math.pow(1 + rate, period)) / (Math.pow(1 + rate, period) - 1));
        String formatMort = NumberFormat.getCurrencyInstance().format(origMort);
        System.out.println("Mortgage:" + formatMort);






    }
}
