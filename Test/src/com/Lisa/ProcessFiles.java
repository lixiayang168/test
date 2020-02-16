package com.Lisa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessFiles {
    private Scanner inputFile;
    public void openFile(){
        try{
            inputFile = new Scanner(new File("/Users/baidu/IdeaProjects/Test/src/com/data.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("could not find the file");
        }
    }
    public void readFile(){
        while(inputFile.hasNext()){
            String userId = inputFile.next();
            String firstName = inputFile.next();
            String lastName = inputFile.next();
            System.out.printf("Number:%s Name:%s %s \n",userId,firstName,lastName);
        }
    }

    public void closeFile(){
        inputFile.close();
    }

}
