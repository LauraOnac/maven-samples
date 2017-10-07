package com.calculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestCalculator {

  private Calculator calculator;

  @Before
  public void setUp() {
    calculator = new Calculator();
  }

  @Test
  public void complexExpression(){
    double result = calculator.compute("1+2*3-12/2");
    assertTrue(result == 1);
  }

  @Test(expected = CalculatorException.class)
  public void divisionByZero(){
    calculator.compute("20+1/2/0-20*3");
  }

  @Test(expected = CalculatorException.class)
  public void emptyExpression(){
    calculator.compute("");
  }

  @Test(expected = CalculatorException.class)
  public void invalidExpression(){
    calculator.compute("1++2");
  }

  @Test(expected = CalculatorException.class)
  public void invalidInput(){
    calculator.compute("lalala");
  }
}
