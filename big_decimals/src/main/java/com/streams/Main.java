package com.streams;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by Laura on 10/31/2017.
 */
public class Main {
    public static void main(String [ ] args){
        Sum sum = new Sum();
        Average average = new Average();
        Top10Percent top10Percent = new Top10Percent();
        BigDecimalSerializer bigDecimalSerializer = new BigDecimalSerializer("big_decimals/src/main/java/resources/big_decimals.txt");
        LambdaSerializer lambdaSerializer = new LambdaSerializer("big_decimals/src/main/java/resources/lambda.txt");

        List<BigDecimal> list = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            list.add(new BigDecimal(i));
        }

        BigDecimal sumResult = sum.compute(list);
        BigDecimal averageResult = average.compute(list);
        List<BigDecimal> top10Result = top10Percent.compute(list);

        System.out.println("Sum: " + sumResult);
        System.out.println("Average: " + averageResult);
        System.out.print("Top10Percent: ");
        for(BigDecimal number: top10Result){
            System.out.print(number + "  ");
        }

        System.out.println("\nSerializing and Deserializing BigDecimals:");
        bigDecimalSerializer.serializeBigDecimals(list);
        List<BigDecimal> numbers = bigDecimalSerializer.deserializeBigDecimals();
        for(BigDecimal number: numbers){
            System.out.print(number + ", ");
        }
        System.out.println();

        System.out.println("\nSerializing and Deserializing Lambda:");
        BiFunction<BigDecimal,BigDecimal,BigDecimal> lambda = (BiFunction<BigDecimal,BigDecimal,BigDecimal> & Serializable)(number1,number2) -> number1.add(number2);
        lambdaSerializer.serializeLambda(lambda);
        BiFunction<BigDecimal,BigDecimal,BigDecimal> deserializedLambda = lambdaSerializer.deserializeLambda();
        BigDecimal n1 = new BigDecimal(1);
        BigDecimal n2 = new BigDecimal(1);
        BigDecimal r = deserializedLambda.apply(n1,n2);
        System.out.println("Sum");
        System.out.println("1 + 1 = " + r);
    }
}
