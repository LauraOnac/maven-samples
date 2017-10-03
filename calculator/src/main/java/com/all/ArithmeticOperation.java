package com.all;

/**
 * Created by Laura on 10/3/2017.
 */
public abstract class ArithmeticOperation {
    protected float operand1;
    protected float operand2;

    public ArithmeticOperation(float operand1, float operand2){
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public abstract double execute();
}
