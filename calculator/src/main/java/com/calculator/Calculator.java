package com.calculator;

import com.calculator.operations.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Laura on 10/3/2017.
 */
public class Calculator {
    private Map<Operator,Operation> operations;
    
    public Calculator(){
        operations = new HashMap<>();
        operations.put(Operator.PLUS, new Addition());
        operations.put(Operator.MINUS, new Subtraction());
        operations.put(Operator.TIMES, new Multiplication());
        operations.put(Operator.DIVIDE, new Division());
    }

    public double compute(String expression){
        return computeSum(expression);
    }

    private double computeSum(String expression){
        String[] items = splitExpression(expression, Operator.PLUS);
        List<Double> numbers = getOperands(items, Operator.MINUS);
        return operations.get(Operator.PLUS).execute(numbers);
    }

    private double computeDifference(String expression){
        String[] items = splitExpression(expression, Operator.MINUS);
        List<Double> numbers = getOperands(items, Operator.TIMES);
        return operations.get(Operator.MINUS).execute(numbers);
    }

    private double computeProduct(String expression){
        String[] items = splitExpression(expression, Operator.TIMES);
        List<Double> numbers = getOperands(items, Operator.DIVIDE);
        return operations.get(Operator.TIMES).execute(numbers);
    }

    private double computeQuotient(String expression){
        String[] items = splitExpression(expression, Operator.DIVIDE);
        List<Double> numbers = getOperands(items, Operator.NONE);
        return operations.get(Operator.DIVIDE).execute(numbers);
    }

    private String[] splitExpression(String expression, Operator operator) throws CalculatorException{
        String[] items = expression.split("\\" + operator.getSign());
        if(items.length == 1 && !items[0].equals(expression))
            throw new CalculatorException("Invalid expression!");
        int noOperatorMatches = StringUtils.countMatches(expression, operator.getSign());
        if(items.length > 1 && items.length != noOperatorMatches + 1)
            throw new CalculatorException("Invalid expression!");
        return items;
    }

    private List<Double> getOperands(String[] items, Operator higherPriorityOperation) throws CalculatorException{
        List<Double> numbers = new ArrayList<>();
        int index;
        for (index = 0; index < items.length; index++){
            Double number;
            try
            {
                number = Double.parseDouble(items[index]);
            }
            catch(NumberFormatException e) {
                switch (higherPriorityOperation) {
                    case MINUS:
                        number = computeDifference(items[index]);
                        break;
                    case TIMES:
                        number = computeProduct(items[index]);
                        break;
                    case DIVIDE:
                        number = computeQuotient(items[index]);
                        break;
                    default:
                        throw new CalculatorException("Invalid expression!");
                }
            }
            numbers.add(number);
        }
        return numbers;
    }
}
