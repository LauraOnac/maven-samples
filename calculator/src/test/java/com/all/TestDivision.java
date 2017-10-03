package com.all;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestDivision {

  @Test
  public void divideByOne() {
    Division division = new Division(2,1);
    assertTrue(division.execute() == 2);
  }

  @Test(expected = ArithmeticException.class)
  public void divideByZero() {
    Division division = new Division(1,0);
    division.execute();
  }

  @Test
  public void divideIntegers() {
    Division division = new Division(3,6);
    assertTrue(division.execute() == 0.5);
  }

  @Test
  public void divideFloats() {
    Division division = new Division(1.5f,2.5f);
    assertTrue(division.execute() == 0.6000000238418579);
  }

}
