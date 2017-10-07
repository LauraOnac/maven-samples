package com.calculator.operations;

import com.calculator.CalculatorException;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class TestMultiplication {

    private Multiplication multiplication;

    @Before
    public void setUp() {
        multiplication = new Multiplication();
    }

    @Test(expected = CalculatorException.class)
    public void multiplicationWithoutOperands() {
        List<Double> operands = new ArrayList<>();
        multiplication.execute(operands);
    }

    @Test
    public void multiplicationWithOneOperand() {
        List<Double> operands = new ArrayList<>();
        operands.add(1d);
        assertTrue(multiplication.execute(operands) == 1);
    }

    @Test
    public void multiplicationWithTwoOperands() {
        List<Double> operands = new ArrayList<>();
        operands.add(1d);
        operands.add(2d);
        assertTrue(multiplication.execute(operands) == 2);
    }

    @Test
    public void multiplicationWithThreeOperands() {
        List<Double> operands = new ArrayList<>();
        operands.add(2d);
        operands.add(3d);
        operands.add(4d);
        assertTrue(multiplication.execute(operands) == 24);
    }
}
