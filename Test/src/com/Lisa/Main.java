package com.Lisa;

import javax.sound.midi.Soundbank;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        //primitive types
        long pageView = 3_000_000_000L;
        float price = 10.99F;

        //reference types String
        String message = "  Hello World " + "!! ";
        boolean assertEnd = message.endsWith("a");
        boolean assertStart = message.startsWith("H");
        int length = message.length();
        int index = message.indexOf("l");
        String replace = message.replace("l","a");
        String toLower = message.toLowerCase();
        String toUpper = message.toUpperCase();
        String trim = message.trim();
        System.out.println(message + "\n" + length + "\t" + index + "\n" + replace + "\n" + toLower + "\n" + toUpper + "\n" + trim);
        System.out.println(message.intern());

        //reference types Array
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        String numberString = Arrays.toString(numbers);
        System.out.println(numberString);
        String[] names = new String[5];
        names[0] = "Lisa";
        names[1] = "Kevin";
        String nameString = Arrays.toString(names);
        System.out.println(nameString);
        int[] ages = {30,35,21,19};
        int size = ages.length;
        Arrays.sort(ages);
        System.out.println(size + "\n" + Arrays.toString(ages));
        int[][] multiNum = new int[2][3];// 2 rows and 3 columns
        multiNum[0][0] = 1;
        multiNum[0][1] = 2;
        System.out.println(Arrays.deepToString(multiNum));

        //constant
        final float PI = 3.14F;

        //arithmetic operators
        double result = (double)10 / (double)3;
        System.out.println(result);
        int x = 1;
        int y = x++; //postfix: x copy to y and then x plus 1
        x = 1;
        int z = ++x; //prefix: x plus 1 and then copy to z
        x = 1;
        x = x + 2;
        x += 2;
        System.out.println("x:" + x + " y:" + y + " z:" + z);

        //implicit casting: byte > short > int > long > float > double
        float a = 1.1f;
        float b = a + 2;
        System.out.println(b);

        //explicit casting
        double c = 1.1;
        int d = (int)c + 2;
        System.out.println(d);

        //string to int
        String e = "1";
        int f = Integer.parseInt(e) + 5;
        System.out.println(f);

        //the math class
        int resultRound = Math.round(1.6F);
        int resultCell = (int)Math.ceil(1.1F);
        int resultFloor = (int)Math.floor(1.1F);
        int resultMax = Math.max(1,9);
        double resultRandom = Math.random(); //float number between 0 to 1
        System.out.println(resultRound + "\n" + resultCell + "\n" + resultFloor + "\n" + resultMax + "\n" + resultRandom);

        //format numbers
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String resultCurrency = currency.format(1234567.889);
        System.out.println(resultCurrency);
        NumberFormat percent = NumberFormat.getPercentInstance();
        String resultPercent = percent.format(0.234);
        System.out.println(resultPercent);

        //reading input
        Scanner scanner = new Scanner(System.in);
        //byte age = scanner.nextByte();
        //System.out.println("you are: " + age);
        //String firstName = scanner.next(); // read the each word
        //System.out.println(firstName);
        //String fullName = scanner.nextLine();// read the whole line
        //System.out.println(fullName);

        //ternary operator
        int income = 120_000;
        String className = income > 100_000 ? "First" : "Economy";
        System.out.println(className);



        //read files
        ProcessFiles processFiles = new ProcessFiles();
        processFiles.openFile();
        processFiles.readFile();
        processFiles.closeFile();

        //send Http requests
        SendHttp.callMe();















    }
}
