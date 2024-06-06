package com.klxsolutions.propertymanagement.controller;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController();
        Double result = calculatorController.add(4.5,5.5,9.0);
        System.out.println(result);
    }
}
