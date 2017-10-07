package com.calculator;

import java.util.Scanner;

/**
 * Created by Laura on 10/7/2017.
 */
public class Main {

    public static void main(String [ ] args){
        Calculator calculator = new Calculator();
        String expression;
        Double result;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Enter arithmetic expression: ");
            expression = scanner.nextLine();
            try {
                result = calculator.compute(expression);
                System.out.println("The result is: " + result + "\n");
            }catch(CalculatorException e){
                System.out.println(e.getMessage() + "\n");
            }

        }
    }
}
