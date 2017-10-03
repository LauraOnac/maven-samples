package com.all;

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
  public void addToZero() {
    double result = calculator.compute("0+1");
    assertTrue(result == 1);
  }

  @Test
  public void addIntegers() {
    double result = calculator.compute("1+2");
    assertTrue(result == 3);
  }

  @Test
  public void addFloats() {
    double result = calculator.compute("1.5+2.5");
    assertTrue(result == 4);
  }

  @Test
  public void subtractWithZero() {
    double result;
    result = calculator.compute("1-0");
    assertTrue(result == 1);
  }

  @Test
  public void subtractFromZero() {
    double result;
    result = calculator.compute("0-1");
    assertTrue(result == -1);
  }
  @Test
  public void subtractIntegers() {
    double result = calculator.compute("2-1");
    assertTrue(result == 1);
  }
  @Test
  public void subtractFloats() {
    double result = calculator.compute("5.5-1.5");
    assertTrue(result == 4);
  }

  @Test
  public void multiplyWithOne() {
    double result = calculator.compute("1*2");
    assertTrue(result == 2);
  }

  @Test
  public void multiplyWithZero() {
    double result = calculator.compute("0*2");
    assertTrue(result == 0);
  }
  @Test
  public void multiplyIntegers() {
    double result = calculator.compute("2*3");
    assertTrue(result == 6);
  }
  @Test
  public void multiplyFloats() {
    double result = calculator.compute("1.5*2.5");
    assertTrue(result == 3.75);
  }

  @Test
  public void divideByOne() {
    double result = calculator.compute("2/1");
    assertTrue(result == 2);
  }

  @Test(expected = ArithmeticException.class)
  public void divideByZero() {
    calculator.compute("1/0");
  }

  @Test
  public void divideIntegers() {
    double result = calculator.compute("3/6");
    assertTrue(result == 0.5);
  }

  @Test
  public void divideFloats() {
    double result = calculator.compute("1.5/2.5");
    assertTrue(result == 0.6000000238418579);
  }

  @Test(expected = RuntimeException.class)
  public void unrecognizedOperation() {
    calculator.compute("10^3");
  }

  @Test(expected = RuntimeException.class)
  public void invalidInput() {
    calculator.compute("lalala");
  }

}
