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
    private List<BigDecimal> list1000;

    @Before
    public void setUp(){
        serializer = new BigDecimalSerializer("src/test/java/resources/big_decimals.txt");
        list1000 = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            list1000.add(new BigDecimal(i));
        }
    }

    @Test
    public void test_serialize_deserialize(){
        serializer.serializeBigDecimals(list1000);
        List<BigDecimal> numbers = serializer.deserializeBigDecimals();
        for(int index = 0; index < list1000.size(); index++){
            assertThat(list1000.get(index), is(equalTo(numbers.get(index))));
        }
    }

}