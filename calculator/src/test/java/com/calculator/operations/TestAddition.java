package com.calculator.operations;

import com.calculator.CalculatorException;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestAddition {

  private Addition addition;

  @Before
  public void setUp() {
        addition = new Addition();
    }

  @Test(expected = CalculatorException.class)
  public void additionWithoutOperands() {
      List<Double> operands = new ArrayList<>();
      addition.execute(operands);
  }

  @Test
  public void additionWithOneOperand() {
    List<Double> operands = new ArrayList<>();
    operands.add(1d);
    double result = addition.execute(operands);
    assertThat(result, is(equalTo(1.0)));
  }

  @Test
  public void additionWithTwoOperands() {
    List<Double> operands = new ArrayList<>();
    operands.add(1d);
    operands.add(2d);
    double result = addition.execute(operands);
    assertThat(result, is(equalTo(3.0)));
  }

  @Test
  public void addWithThreeOperands() {
    List<Double> operands = new ArrayList<>();
    operands.add(1d);
    operands.add(2d);
    operands.add(3d);
    double result = addition.execute(operands);
    assertThat(result, is(equalTo(6.0)));
  }
}
