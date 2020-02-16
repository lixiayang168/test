package com.Lisa;

public class Calculator {
    CalculatorService service;
    public int myAdd(int i, int j){
        return service.add(i,j);
    }
}
