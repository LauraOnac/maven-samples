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
public class Top10Test {
    private Top10 top10;
    private List<BigDecimal> list1000;

    @Before
    public void setUp(){
        top10 = new Top10();
        list1000 = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            list1000.add(new BigDecimal(i));
        }
    }

    @Test
    public void test_compute(){
        List<BigDecimal> top10Result = top10.compute(list1000);
        List<BigDecimal> top10Expected = new ArrayList<>();
        for(int i = 999; i > 989; i--){
            top10Expected.add(new BigDecimal(i));
        }
        for(int i = 0; i < 10; i++){
            assertThat(top10Result.get(i), is(equalTo(top10Expected.get(i))));
        }
    }

}