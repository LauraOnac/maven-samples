package com.calculator.operations;

import com.calculator.CalculatorException;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class TestDivision {

    private Division division;

    @Before
    public void setUp() {
        division = new Division();
    }

    @Test(expected = CalculatorException.class)
    public void divisionWithoutOperands() {
        List<Double> operands = new ArrayList<>();
        division.execute(operands);
    }

    @Test
    public void divisionWithOneOperand() {
        List<Double> operands = new ArrayList<>();
        operands.add(1d);
        assertTrue(division.execute(operands) == 1);
    }

    @Test
    public void divisionWithTwoOperands() {
        List<Double> operands = new ArrayList<>();
        operands.add(1d);
        operands.add(2d);
        assertTrue(division.execute(operands) == 0.5);
    }

    @Test
    public void divisionWithThreeOperands() {
        List<Double> operands = new ArrayList<>();
        operands.add(10d);
        operands.add(2d);
        operands.add(2d);
        assertTrue(division.execute(operands) == 2.5);
    }

    @Test(expected = CalculatorException.class)
    public void divisionByZero() {
        List<Double> operands = new ArrayList<>();
        operands.add(10d);
        operands.add(0d);
        division.execute(operands);
    }
}
