package com.calculator.operations;

import com.calculator.CalculatorException;

/**
 * Created by Laura on 10/21/2017.
 */
public enum Operator{
    PLUS,
    MINUS,
    TIMES,
    DIVIDE,
    NONE;

    public String getSign(){
        switch(this){
            case PLUS:
                return "+";
            case MINUS:
                return "-";
            case TIMES:
                return "*";
            case DIVIDE:
                return "/";
            case NONE:
                return "";
            default:
                throw new CalculatorException("Unknown operator " + this);
        }
    }
}
