package com.streams;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.function.BiFunction;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Laura on 11/9/2017.
 */
public class LambdaSerializerTest {
    private LambdaSerializer serializer;
    private BiFunction<BigDecimal,BigDecimal,BigDecimal> sum;
    private BigDecimal n1;
    private BigDecimal n2;
    private BigDecimal n3;
    private BigDecimal n4;
    private BigDecimal n5;
    private BigDecimal n6;

    @Before
    public void setUp(){
        serializer = new LambdaSerializer("src/test/java/resources/lambda.txt");
        sum = (BiFunction<BigDecimal,BigDecimal,BigDecimal> & Serializable)(number1, number2) -> number1.add(number2);
        n1 = new BigDecimal(100000);
        n2 = new BigDecimal(100000);
        n3 = new BigDecimal(1000000);
        n4 = new BigDecimal(1000000);
        n5 = new BigDecimal(10000000);
        n6 = new BigDecimal(10000000);
    }

    @Test
    public void serializeDeserializeSum(){
        serializer.serializeLambda(sum);
        BiFunction<BigDecimal,BigDecimal,BigDecimal> deserializedSum = serializer.deserializeLambda();
        BigDecimal result = deserializedSum.apply(n1,n2);
        BigDecimal expected = new BigDecimal(200000);
        assertThat(result, is(equalTo(expected)));
        result = deserializedSum.apply(n3,n4);
        expected = new BigDecimal(2000000);
        assertThat(result, is(equalTo(expected)));
        result = deserializedSum.apply(n5,n6);
        expected = new BigDecimal(20000000);
        assertThat(result, is(equalTo(expected)));
    }
}