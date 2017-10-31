package com.streams;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Laura on 10/31/2017.
 */
public class Sum {
    public BigDecimal compute(List<BigDecimal> list){
        return list.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
