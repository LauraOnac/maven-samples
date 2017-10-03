package com.all;

/**
 * Created by Laura on 10/3/2017.
 */
public class Division extends ArithmeticOperation {

    public Division(float operand1, float operand2) {
        super(operand1, operand2);
    }

    @Override
    public double execute() throws ArithmeticException{
        if(this.operand2 == 0){
            throw new ArithmeticException("Division by zero!");
        }
        return this.operand1 / this.operand2;
    }
}
