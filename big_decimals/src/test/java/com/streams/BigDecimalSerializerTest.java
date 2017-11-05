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
 * Created by Laura on 11/5/2017.
 */
public class BigDecimalSerializerTest {
    private BigDecimalSerializer serializer;
    private List<BigDecimal> list;

    @Before
    public void setUp(){
        serializer = new BigDecimalSerializer("src/test/java/resources/big_decimals.txt");
        list = new ArrayList<>();
    }

    @Test
    public void testSerializeAndDeserialize1000(){
        for(int i = 0; i < 1000; i++){
            list.add(new BigDecimal(i));
        }
        serializer.serializeBigDecimals(list);
        List<BigDecimal> numbers = serializer.deserializeBigDecimals();
        for(int index = 0; index < list.size(); index++){
            assertThat(list.get(index), is(equalTo(numbers.get(index))));
        }
        list.clear();
    }

    @Test
    public void testSerializeAndDeserialize10000(){
        for(int i = 0; i < 10000; i++){
            list.add(new BigDecimal(i));
        }
        serializer.serializeBigDecimals(list);
        List<BigDecimal> numbers = serializer.deserializeBigDecimals();
        for(int index = 0; index < list.size(); index++){
            assertThat(list.get(index), is(equalTo(numbers.get(index))));
        }
        list.clear();
    }

    @Test
    public void testSerializeAndDeserialize100000(){
        for(int i = 0; i < 100000; i++){
            list.add(new BigDecimal(i));
        }
        serializer.serializeBigDecimals(list);
        List<BigDecimal> numbers = serializer.deserializeBigDecimals();
        for(int index = 0; index < list.size(); index++){
            assertThat(list.get(index), is(equalTo(numbers.get(index))));
        }
        list.clear();
    }

    @Test
    public void testSerializeAndDeserialize1000000(){
        for(int i = 0; i < 1000000; i++){
            list.add(new BigDecimal(i));
        }
        serializer.serializeBigDecimals(list);
        List<BigDecimal> numbers = serializer.deserializeBigDecimals();
        for(int index = 0; index < list.size(); index++){
            assertThat(list.get(index), is(equalTo(numbers.get(index))));
        }
        list.clear();
    }

//    @Test
//    public void testSerializeAndDeserialize10000000(){
//        for(int i = 0; i < 10000000; i++){
//            list.add(new BigDecimal(i));
//        }
//        serializer.serializeBigDecimals(list);
//        List<BigDecimal> numbers = serializer.deserializeBigDecimals();
//        for(int index = 0; index < list.size(); index++){
//            assertThat(list.get(index), is(equalTo(numbers.get(index))));
//        }
//        list.clear();
//    }
//
//    @Test
//    public void testSerializeAndDeserialize100000000(){
//        for(int i = 0; i < 100000000; i++){
//            list.add(new BigDecimal(i));
//        }
//        serializer.serializeBigDecimals(list);
//        List<BigDecimal> numbers = serializer.deserializeBigDecimals();
//        for(int index = 0; index < list.size(); index++){
//            assertThat(list.get(index), is(equalTo(numbers.get(index))));
//        }
//        list.clear();
//    }
}