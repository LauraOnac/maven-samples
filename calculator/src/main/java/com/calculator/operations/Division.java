package com.calculator.operations;

import com.calculator.CalculatorException;
import com.calculator.operations.Operation;

import java.util.List;

/**
 * Created by Laura on 10/3/2017.
 */
public class Division implements Operation {
    @Override
    public double execute(List<Double> operands) throws CalculatorException {
        if(operands.size() == 0)
            throw new CalculatorException("Operation without operands!");

        double quotient = operands.get(0);
        operands.remove(0);
        for (Double operand : operands) {
            if(operand == 0)
                throw new CalculatorException("Division by zero!");
            quotient /= operand;
        }
        return quotient;
    }
}
