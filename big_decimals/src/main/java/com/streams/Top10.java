package com.streams;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Laura on 10/31/2017.
 */
public class Top10 {
    public List<BigDecimal> compute(List<BigDecimal> list){
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .collect(Collectors.toList());
    }
}
