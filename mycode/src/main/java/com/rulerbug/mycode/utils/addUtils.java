package com.rulerbug.mycode.utils;

import java.math.BigDecimal;

public class addUtils {
    //相加两个double
    private double add(double b, double money) {
        BigDecimal b1 = new BigDecimal(b + "");
        BigDecimal b2 = new BigDecimal(money + "");
        return b1.add(b2).doubleValue();
    }
}
