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
    private List<BigDecimal> list;
    @Before
    public void setUp(){
        sum = new Sum();
        list = new ArrayList<>();
    }

    @Test
    public void testComputeSum1000(){
        for(int i = 0; i < 1000; i++){
            list.add(new BigDecimal(i));
        }
        BigDecimal sumResult = sum.compute(list);
        BigDecimal sumExpected = new BigDecimal(499500);
        assertThat(sumResult, is(equalTo(sumExpected)));
        list.clear();
    }

    @Test
    public void testComputeSum10000(){
        for(int i = 0; i < 10000; i++){
            list.add(new BigDecimal(i));
        }
        BigDecimal sumResult = sum.compute(list);
        BigDecimal sumExpected = new BigDecimal(49995000);
        assertThat(sumResult, is(equalTo(sumExpected)));
        list.clear();
    }

    @Test
    public void testComputeSum100000(){
        for(int i = 0; i < 100000; i++){
            list.add(new BigDecimal(i));
        }
        BigDecimal sumResult = sum.compute(list);
        BigDecimal sumExpected = new BigDecimal(4999950000l);
        assertThat(sumResult, is(equalTo(sumExpected)));
        list.clear();
    }

    @Test
    public void testComputeSum1000000(){
        for(int i = 0; i < 1000000; i++){
            list.add(new BigDecimal(i));
        }
        BigDecimal sumResult = sum.compute(list);
        BigDecimal sumExpected = new BigDecimal(499999500000l);
        assertThat(sumResult, is(equalTo(sumExpected)));
        list.clear();
    }

    @Test
    public void testComputeSum10000000(){
        for(int i = 0; i < 10000000; i++){
            list.add(new BigDecimal(i));
        }
        BigDecimal sumResult = sum.compute(list);
        BigDecimal sumExpected = new BigDecimal(49999995000000l);
        assertThat(sumResult, is(equalTo(sumExpected)));
        list.clear();
    }

//    @Test
//    public void testComputeSum100000000(){
//        for(int i = 0; i < 100000000; i++){
//            list.add(new BigDecimal(i));
//        }
//        BigDecimal sumResult = sum.compute(list);
//        BigDecimal sumExpected = new BigDecimal(4999999950000000l);
//        assertThat(sumResult, is(equalTo(sumExpected)));
//        list.clear();
//    }
}