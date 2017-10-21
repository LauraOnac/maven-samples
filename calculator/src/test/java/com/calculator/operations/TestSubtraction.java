package com.calculator.operations;

import com.calculator.CalculatorException;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestSubtraction {

  private Subtraction subtraction;

  @Before
  public void setUp() {
        subtraction = new Subtraction();
    }

  @Test(expected = CalculatorException.class)
  public void subtractionWithoutOperands() {
      List<Double> operands = new ArrayList<>();
      subtraction.execute(operands);
  }

  @Test
  public void subtractionWithOneOperand() {
    List<Double> operands = new ArrayList<>();
    operands.add(1d);
    double result = subtraction.execute(operands);
    assertThat(result, is(equalTo(1.0)));
  }

  @Test
  public void subtractionWithTwoOperands() {
    List<Double> operands = new ArrayList<>();
    operands.add(2d);
    operands.add(1d);
    double result = subtraction.execute(operands);
    assertThat(result, is(equalTo(1.0)));
  }

  @Test
  public void subtractionWithThreeOperands() {
    List<Double> operands = new ArrayList<>();
    operands.add(3d);
    operands.add(2d);
    operands.add(1d);
    double result = subtraction.execute(operands);
    assertThat(result, is(equalTo(0.0)));
  }
}
