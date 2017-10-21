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
        System.out.print("Press x whenever you want to stop the calculator...\n\n");
        while(true){
            System.out.print("Enter arithmetic expression: ");
            expression = scanner.nextLine();
            if(expression.equals("x"))
                System.exit(0);
            try {
                result = calculator.compute(expression);
                System.out.println("The result is: " + result + "\n");
            }catch(CalculatorException e){
                System.out.println(e.getMessage() + "\n");
            }
        }
    }
}
