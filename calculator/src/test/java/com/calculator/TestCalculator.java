package com.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestCalculator {

  private Calculator calculator;

  @Before
  public void setUp() {
    calculator = new Calculator();
  }

  @Test
  public void simplePlusExpression(){
    double result = calculator.compute("1+2+3+4");
    assertThat(result, is(equalTo(10.0)));
  }

  @Test
  public void simpleMinusExpression(){
    double result = calculator.compute("1-2-3-4");
    assertThat(result, is(equalTo(-8.0)));
  }

  @Test
  public void simpleMultiplyExpression(){
    double result = calculator.compute("1*2*3*4");
    assertThat(result, is(equalTo(24.0)));
  }

  @Test
  public void simpleDivideExpression(){
    double result = calculator.compute("8/4/2/1");
    assertThat(result, is(equalTo(1.0)));
  }

  @Test
  public void complexExpression(){
    double result = calculator.compute("1+2*3-12/2+1");
    assertThat(result, is(equalTo(2.0)));
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
  public void beginningInvalidExpression(){
    calculator.compute("+1+2");
  }

  @Test(expected = CalculatorException.class)
  public void middleInvalidExpression(){
    calculator.compute("1++2");
  }

  @Test(expected = CalculatorException.class)
  public void endingInvalidExpression(){
    calculator.compute("1+2+");
  }

  @Test(expected = CalculatorException.class)
  public void invalidInput(){
    calculator.compute("lalala");
  }
}
