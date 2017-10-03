package com.all;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestSubtraction {

  @Test
  public void subtractWithZero() {
    Subtraction subtraction = new Subtraction(1,0);
    assertTrue(subtraction.execute() == 1);
  }

  @Test
  public void subtractFromZero() {
    Subtraction subtraction = new Subtraction(0,1);
    assertTrue(subtraction.execute() == -1);
  }

  @Test
  public void subtractIntegers() {
    Subtraction subtraction = new Subtraction(2,1);
    assertTrue(subtraction.execute() == 1);
  }

  @Test
  public void subtractFloats() {
    Subtraction subtraction = new Subtraction(5.5f,1.5f);
    assertTrue(subtraction.execute() == 4);
  }
}
