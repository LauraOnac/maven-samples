package com.calculator;

import com.calculator.operations.Addition;
import com.calculator.operations.Division;
import com.calculator.operations.Multiplication;
import com.calculator.operations.Subtraction;
import org.apache.commons.lang3.StringUtils;

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

    public double compute(String expression){
        return computeSum(expression);
    }

    private double computeSum(String expression){
        String[] items = splitExpression(expression, "\\+");
        List<Double> numbers = getOperands(items, "subtraction");
        return addition.execute(numbers);
    }

    private double computeDifference(String expression){
        String[] items = splitExpression(expression, "-");
        List<Double> numbers = getOperands(items, "multiplication");
        return subtraction.execute(numbers);
    }

    private double computeProduct(String expression){
        String[] items = splitExpression(expression, "\\*");
        List<Double> numbers = getOperands(items, "division");
        return multiplication.execute(numbers);
    }

    private double computeQuotient(String expression){
        String[] items = splitExpression(expression, "/");
        List<Double> numbers = getOperands(items, "none");
        return division.execute(numbers);
    }

    private String[] splitExpression(String expression, String operator) throws CalculatorException{
        String[] items = expression.split(operator);
        if(items.length == 1 && !items[0].equals(expression))
            throw new CalculatorException("Invalid expression!");
        String character = operator;
        if(operator.equals("\\+"))
            character = "+";
        if(operator.equals("\\*"))
            character = "*";
        int noOperatorMatches = StringUtils.countMatches(expression, character);
        if(items.length > 1 && items.length != noOperatorMatches + 1)
            throw new CalculatorException("Invalid expression!");
        return items;
    }

    private List<Double> getOperands(String[] items, String higherPriorityOperation) throws CalculatorException{
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
                    case "subtraction":
                        number = computeDifference(items[index]);
                        break;
                    case "multiplication":
                        number = computeProduct(items[index]);
                        break;
                    case "division":
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
