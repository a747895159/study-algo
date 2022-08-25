package com.person.test;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Desc:
 * @Author: ZhouBin
 * @Date: 2021/9/2
 */
@AllArgsConstructor
public class Test1 {

    private String str;

    public static void main(String[] args) {

        List<BigDecimal> list =new ArrayList<BigDecimal>();
        list.add(null);
        list.add(new BigDecimal("0"));

        BigDecimal reduce = list.stream().filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(reduce);

    }
}
