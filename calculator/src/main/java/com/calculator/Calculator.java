package com.calculator;

import com.calculator.operations.Addition;
import com.calculator.operations.Division;
import com.calculator.operations.Multiplication;
import com.calculator.operations.Subtraction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laura on 10/3/2017.
 */
public class Calculator {
    private Addition addition;
    private Subtraction subtraction;
    private Multiplication multiplication;
    private Division division;

    public Calculator(){
        addition = new Addition();
        subtraction = new Subtraction();
        multiplication = new Multiplication();
        division = new Division();
    }

    public double compute(String expression) throws CalculatorException{
        return computeSum(expression);
    }

    private double computeSum(String expression){
        List<Double> numbers = new ArrayList<>();
        String[] items = splitExpression(expression, "\\+");
        int index;
        for (index = 0; index < items.length; index++){
            Double number;
            try
            {
                number = Double.parseDouble(items[index]);
            }
            catch(NumberFormatException e)
            {
                number = computeDifference(items[index]);
            }
            numbers.add(number);
        }
        return addition.execute(numbers);
    }

    private double computeDifference(String expression){
        List<Double> numbers = new ArrayList<>();
        String[] items = splitExpression(expression, "-");
        int index;
        for (index = 0; index < items.length; index++){
            Double number;
            try
            {
                number = Double.parseDouble(items[index]);
            }
            catch(NumberFormatException e)
            {
                number = computeProduct(items[index]);
            }
            numbers.add(number);
        }
        return subtraction.execute(numbers);
    }

    private double computeProduct(String expression){
        List<Double> numbers = new ArrayList<>();
        String[] items = splitExpression(expression, "\\*");
        int index;
        for (index = 0; index < items.length; index++){
            Double number;
            try
            {
                number = Double.parseDouble(items[index]);
            }
            catch(NumberFormatException e)
            {
                number = computeQuotient(items[index]);
            }
            numbers.add(number);
        }
        return multiplication.execute(numbers);
    }

    private double computeQuotient(String expression) throws CalculatorException{
        List<Double> numbers = new ArrayList<>();
        String[] items = splitExpression(expression, "/");
        int index;
        for (index = 0; index < items.length; index++){
            Double number;
            try
            {
                number = Double.parseDouble(items[index]);
            }
            catch(NumberFormatException e)
            {
                throw new CalculatorException("Invalid expression!");
            }
            numbers.add(number);
        }
        return division.execute(numbers);
    }

    private String[] splitExpression(String expression, String operator){
        String[] items = expression.split(operator);
        if(items.length == 1 && !items[0].equals(expression))
            throw new CalculatorException("Invalid expression");
        return items;
    }
}
