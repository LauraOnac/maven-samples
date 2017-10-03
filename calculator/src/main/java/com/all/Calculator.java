package com.all;

/**
 * Created by Laura on 10/3/2017.
 */
public class Calculator {

    public double compute(String input) throws RuntimeException{
        ArithmeticOperation arithmeticOperation = null;
        double result;

        if(input.contains("+")){
            String[] operands = input.split("\\+");
            float operand1 = Float.parseFloat(operands[0]);
            float operand2 = Float.parseFloat(operands[1]);
            arithmeticOperation = new Addition(operand1, operand2);
        }

        if(input.contains("-")){
            String[] operands = input.split("-");
            float operand1 = Float.parseFloat(operands[0]);
            float operand2 = Float.parseFloat(operands[1]);
            arithmeticOperation = new Subtraction(operand1, operand2);
        }

        if(input.contains("*")){
            String[] operands = input.split("\\*");
            float operand1 = Float.parseFloat(operands[0]);
            float operand2 = Float.parseFloat(operands[1]);
            arithmeticOperation = new Multiplication(operand1, operand2);
        }

        if(input.contains("/")){
            String[] operands = input.split("/");
            float operand1 = Float.parseFloat(operands[0]);
            float operand2 = Float.parseFloat(operands[1]);
            arithmeticOperation = new Division(operand1, operand2);
        }

        try {
            result = arithmeticOperation.execute();
        }catch(NullPointerException e){
            throw new RuntimeException("Unrecognized arithmetic operation!");
        }

        return result;
    }
}
