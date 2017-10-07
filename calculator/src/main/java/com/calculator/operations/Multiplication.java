package com.calculator.operations;

import com.calculator.CalculatorException;
import com.calculator.operations.Operation;

import java.util.List;

/**
 * Created by Laura on 10/3/2017.
 */
public class Multiplication implements Operation {
    @Override
    public double execute(List<Double> operands){
        if(operands.size() == 0)
            throw new CalculatorException("Operation without operands!");

        double product = operands.get(0);
        operands.remove(0);
        for (Double operand : operands) {
            product *= operand;
        }
        return product;
    }
}
