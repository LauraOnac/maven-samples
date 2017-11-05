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
    private List<BigDecimal> list;

    @Before
    public void setUp(){
        average = new Average();
        list = new ArrayList<>();
    }

    @Test
    public void testComputeAverage1000(){
        for(int i = 0; i < 1000; i++){
            list.add(new BigDecimal(i));
        }
        BigDecimal averageResult = average.compute(list);
        BigDecimal averageExpected = new BigDecimal(500);
        assertThat(averageResult, is(equalTo(averageExpected)));
        list.clear();
    }

    @Test
    public void testComputeAverage10000(){
        for(int i = 0; i < 10000; i++){
            list.add(new BigDecimal(i));
        }
        BigDecimal averageResult = average.compute(list);
        BigDecimal averageExpected = new BigDecimal(5000);
        assertThat(averageResult, is(equalTo(averageExpected)));
        list.clear();
    }

    @Test
    public void testComputeAverage100000(){
        for(int i = 0; i < 100000; i++){
            list.add(new BigDecimal(i));
        }
        BigDecimal averageResult = average.compute(list);
        BigDecimal averageExpected = new BigDecimal(50000);
        assertThat(averageResult, is(equalTo(averageExpected)));
        list.clear();
    }

    @Test
    public void testComputeAverage1000000(){
        for(int i = 0; i < 1000000; i++){
            list.add(new BigDecimal(i));
        }
        BigDecimal averageResult = average.compute(list);
        BigDecimal averageExpected = new BigDecimal(500000);
        assertThat(averageResult, is(equalTo(averageExpected)));
        list.clear();
    }

    @Test
    public void testComputeAverage10000000(){
        for(int i = 0; i < 10000000; i++){
            list.add(new BigDecimal(i));
        }
        BigDecimal averageResult = average.compute(list);
        BigDecimal averageExpected = new BigDecimal(5000000);
        assertThat(averageResult, is(equalTo(averageExpected)));
        list.clear();
    }

//    @Test
//    public void testComputeAverage100000000(){
//        for(int i = 0; i < 100000000; i++){
//            list.add(new BigDecimal(i));
//        }
//        BigDecimal averageResult = average.compute(list);
//        BigDecimal averageExpected = new BigDecimal(50000000);
//        assertThat(averageResult, is(equalTo(averageExpected)));
//        list.clear();
//    }

    @Test
    public void testComputeAverageUsingDouble1000(){
        for(int i = 0; i < 1000; i++){
            list.add(new BigDecimal(i));
        }
        OptionalDouble averageResult = average.computeDouble(list);
        double averageExpected = 499.5;
        if(averageResult.isPresent())
            assertThat(averageResult.getAsDouble(), is(equalTo(averageExpected)));
        list.clear();
    }

    @Test
    public void testComputeAverageUsingDouble10000(){
        for(int i = 0; i < 10000; i++){
            list.add(new BigDecimal(i));
        }
        OptionalDouble averageResult = average.computeDouble(list);
        double averageExpected = 4999.5;
        if(averageResult.isPresent())
            assertThat(averageResult.getAsDouble(), is(equalTo(averageExpected)));
        list.clear();
    }

    @Test
    public void testComputeAverageUsingDouble100000(){
        for(int i = 0; i < 100000; i++){
            list.add(new BigDecimal(i));
        }
        OptionalDouble averageResult = average.computeDouble(list);
        double averageExpected = 49999.5;
        if(averageResult.isPresent())
            assertThat(averageResult.getAsDouble(), is(equalTo(averageExpected)));
        list.clear();
    }

    @Test
    public void testComputeAverageUsingDouble1000000(){
        for(int i = 0; i < 1000000; i++){
            list.add(new BigDecimal(i));
        }
        OptionalDouble averageResult = average.computeDouble(list);
        double averageExpected = 499999.5;
        if(averageResult.isPresent())
            assertThat(averageResult.getAsDouble(), is(equalTo(averageExpected)));
        list.clear();
    }

    @Test
    public void testComputeAverageUsingDouble10000000(){
        for(int i = 0; i < 10000000; i++){
            list.add(new BigDecimal(i));
        }
        OptionalDouble averageResult = average.computeDouble(list);
        double averageExpected = 4999999.5;
        if(averageResult.isPresent())
            assertThat(averageResult.getAsDouble(), is(equalTo(averageExpected)));
        list.clear();
    }

//    @Test
//    public void testComputeAverageUsingDouble100000000(){
//        for(int i = 0; i < 100000000; i++){
//            list.add(new BigDecimal(i));
//        }
//        OptionalDouble averageResult = average.computeDouble(list);
//        double averageExpected = 49999999.5;
//        if(averageResult.isPresent())
//            assertThat(averageResult.getAsDouble(), is(equalTo(averageExpected)));
//        list.clear();
//    }
}