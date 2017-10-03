package com.all;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestMultiplication {

  @Test
  public void multiplyWithOne() {
    Multiplication multiplication = new Multiplication(1,2);
    assertTrue(multiplication.execute() == 2);
  }

  @Test
  public void multiplyWithZero() {
    Multiplication multiplication = new Multiplication(0,2);
    assertTrue(multiplication.execute() == 0);
  }

  @Test
  public void multiplyIntegers() {
    Multiplication multiplication = new Multiplication(2,3);
    assertTrue(multiplication.execute() == 6);
  }

  @Test
  public void multiplyFloats() {
    Multiplication multiplication = new Multiplication(1.5f,2.5f);
    assertTrue(multiplication.execute() == 3.75);
  }

}
