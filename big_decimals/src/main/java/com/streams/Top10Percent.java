package com.streams;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Laura on 10/31/2017.
 */
public class Top10Percent {
    public List<BigDecimal> compute(List<BigDecimal> list){
        long top = (new Double(0.1 * list.size())).longValue();
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(top)
                .collect(Collectors.toList());
    }
}
