package com.streams;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Laura on 10/31/2017.
 */
public class Top10PercentTest {
    private Top10Percent top10Percent;
    private List<BigDecimal> list;

    @Before
    public void setUp(){
        top10Percent = new Top10Percent();
        list = new ArrayList<>();
    }

    @Test
    public void testComputeTop10From1000(){
        for(int i = 0; i < 1000; i++){
            list.add(new BigDecimal(i));
        }
        List<BigDecimal> top10Result = top10Percent.compute(list);
        List<BigDecimal> top10Expected = new ArrayList<>();
        for(int i = 999; i > 899; i--){
            top10Expected.add(new BigDecimal(i));
        }
        for(int i = 0; i < 100; i++){
            assertThat(top10Result.get(i), is(equalTo(top10Expected.get(i))));
        }
        list.clear();
    }

    @Test
    public void testComputeTop10From10000(){
        for(int i = 0; i < 10000; i++){
            list.add(new BigDecimal(i));
        }
        List<BigDecimal> top10Result = top10Percent.compute(list);
        List<BigDecimal> top10Expected = new ArrayList<>();
        for(int i = 9999; i > 8999; i--){
            top10Expected.add(new BigDecimal(i));
        }
        for(int i = 0; i < 1000; i++){
            assertThat(top10Result.get(i), is(equalTo(top10Expected.get(i))));
        }
        list.clear();
    }

    @Test
    public void testComputeTop10From100000(){
        for(int i = 0; i < 100000; i++){
            list.add(new BigDecimal(i));
        }
        List<BigDecimal> top10Result = top10Percent.compute(list);
        List<BigDecimal> top10Expected = new ArrayList<>();
        for(int i = 99999; i > 89999; i--){
            top10Expected.add(new BigDecimal(i));
        }
        for(int i = 0; i < 10000; i++){
            assertThat(top10Result.get(i), is(equalTo(top10Expected.get(i))));
        }
        list.clear();
    }

    @Test
    public void testComputeTop10From1000000(){
        for(int i = 0; i < 1000000; i++){
            list.add(new BigDecimal(i));
        }
        List<BigDecimal> top10Result = top10Percent.compute(list);
        List<BigDecimal> top10Expected = new ArrayList<>();
        for(int i = 999999; i > 899999; i--){
            top10Expected.add(new BigDecimal(i));
        }
        for(int i = 0; i < 100000; i++){
            assertThat(top10Result.get(i), is(equalTo(top10Expected.get(i))));
        }
        list.clear();
    }

    @Test
    public void testComputeTop10From10000000(){
        for(int i = 0; i < 10000000; i++){
            list.add(new BigDecimal(i));
        }
        List<BigDecimal> top10Result = top10Percent.compute(list);
        List<BigDecimal> top10Expected = new ArrayList<>();
        for(int i = 9999999; i > 8999999; i--){
            top10Expected.add(new BigDecimal(i));
        }
        for(int i = 0; i < 1000000; i++){
            assertThat(top10Result.get(i), is(equalTo(top10Expected.get(i))));
        }
        list.clear();
    }

//    @Test
//    public void testComputeTop10From100000000(){
//        for(int i = 0; i < 100000000; i++){
//            list.add(new BigDecimal(i));
//        }
//        List<BigDecimal> top10Result = top10Percent.compute(list);
//        List<BigDecimal> top10Expected = new ArrayList<>();
//        for(int i = 99999999; i > 99999989; i--){
//            top10Expected.add(new BigDecimal(i));
//        }
//        for(int i = 0; i < 10; i++){
//            assertThat(top10Result.get(i), is(equalTo(top10Expected.get(i))));
//        }
//        list.clear();
//    }
}