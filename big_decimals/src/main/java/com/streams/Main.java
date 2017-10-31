package com.streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laura on 10/31/2017.
 */
public class Main {
    public static void main(String [ ] args){
        Sum sum = new Sum();
        Average average = new Average();
        Top10 top10 = new Top10();

        List<BigDecimal> list = new ArrayList<>();
        for(int i = 0; i < 1000; i+=1){
            list.add(new BigDecimal(i));
        }

        BigDecimal sumResult = sum.compute(list);
        BigDecimal averageResult = average.compute(list);
        List<BigDecimal> top10Result = top10.compute(list);

        System.out.println("Sum: " + sumResult);
        System.out.println("Average: " + averageResult);
        System.out.print("Top10: ");
        for(BigDecimal number: top10Result){
            System.out.print(number + "  ");
        }
    }
}
