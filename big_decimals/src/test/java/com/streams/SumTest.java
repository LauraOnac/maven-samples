package com.streams;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by Laura on 10/31/2017.
 */
public class SumTest {
    private Sum sum;
    private List<BigDecimal> list1000;

    @Before
    public void setUp(){
        sum = new Sum();
        list1000 = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            list1000.add(new BigDecimal(i));
        }
    }

    @Test
    public void test_compute(){
        BigDecimal sumResult = sum.compute(list1000);
        BigDecimal sumExpected = new BigDecimal(499500);
        assertThat(sumResult, is(equalTo(sumExpected)));
    }
}