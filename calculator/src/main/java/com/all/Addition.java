package com.all;

/**
 * Created by Laura on 10/3/2017.
 */
public class Addition extends ArithmeticOperation {

    public Addition(float operand1, float operand2) {
        super(operand1, operand2);
    }

    @Override
    public double execute() {
        return this.operand1 + this.operand2;
    }
}
