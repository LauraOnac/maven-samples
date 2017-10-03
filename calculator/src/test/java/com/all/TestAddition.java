package com.all;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestAddition {

  @Test
  public void addWithZero() {
    Addition addition = new Addition(0,1);
    assertTrue(addition.execute() == 1);
  }

  @Test
  public void addIntegers() {
    Addition addition = new Addition(1,2);
    assertTrue(addition.execute() == 3);
  }

  @Test
  public void addFloats() {
    Addition addition = new Addition(1.5f,2.5f);
    assertTrue(addition.execute() == 4);
  }

}
