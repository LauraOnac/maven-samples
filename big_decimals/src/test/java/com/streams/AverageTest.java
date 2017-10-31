package com.streams;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Laura on 10/31/2017.
 */
public class AverageTest {
    private Average average;
    private List<BigDecimal> list1000;

    @Before
    public void setUp(){
        average = new Average();
        list1000 = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            list1000.add(new BigDecimal(i));
        }
    }

    @Test
    public void test_compute(){
        BigDecimal averageResult = average.compute(list1000);
        BigDecimal averageExpected = new BigDecimal(500);
        assertThat(averageResult, is(equalTo(averageExpected)));
    }

    @Test
    public void test_compute_double(){
        OptionalDouble averageResult = average.computeDouble(list1000);
        double averageExpected = 499.5;
        if(averageResult.isPresent())
            assertThat(averageResult.getAsDouble(), is(equalTo(averageExpected)));
    }
}