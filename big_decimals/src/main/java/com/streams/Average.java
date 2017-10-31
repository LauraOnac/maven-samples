package com.streams;

import java.math.BigDecimal;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Created by Laura on 10/31/2017.
 */
public class Average {
    public BigDecimal compute(List<BigDecimal> list){
        BigDecimal sum = list.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal count = new BigDecimal(list.stream().count());
        return sum.divide(count, BigDecimal.ROUND_HALF_UP);
    }

    public OptionalDouble computeDouble(List<BigDecimal> list){
        return list.stream().mapToDouble(BigDecimal::doubleValue).average();
    }
}
