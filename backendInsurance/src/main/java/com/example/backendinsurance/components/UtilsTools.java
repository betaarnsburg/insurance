package com.example.backendinsurance.components;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * ClassName: UtilsTools
 * Package: com.example.backendinsurance.components
 * Description:
 * Author: Jianan Gu
 * Creat: 25.05.24-22:14
 * Version: v1.0
 */
@Component
@Data
public class UtilsTools {

    public BigDecimal integerPlus(Integer a, Integer b) {
        return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b));
    }
    public BigDecimal integerMinus(Integer a, Integer b) {
        return BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b));
    }
    public BigDecimal integerMultiply(Integer a, Integer b) {
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
    }
    public BigDecimal integerDivide(Integer a, Integer b) {
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_UP);
    }
    public BigDecimal doublePlus(Double a, Double b) {
        return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b));
    }
    public BigDecimal doubleMinus(Double a, Double b) {
        return BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b));
    }
    public BigDecimal doubleMultiply(Double a, Double b) {
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
    }
    public BigDecimal doubleDivide(Double a, Double b) {
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_UP);
    }
    public BigDecimal floatPlus(Float a, Float b) {
        return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b));
    }
    public BigDecimal floatMinus(Float a, Float b) {
        return BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b));
    }
    public BigDecimal floatMultiply(Float a, Float b) {
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
    }
    public BigDecimal floatDivide(Float a, Float b) {
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_UP);
    }
    public BigDecimal longPlus(Long a, Long b) {
        return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b));
    }
    public BigDecimal longMinus(Long a, Long b) {
        return BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b));
    }
    public BigDecimal longMultiply(Long a, Long b) {
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
    }
    public BigDecimal longDivide(Long a, Long b) {
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_UP);
    }
    public BigDecimal shortPlus(Short a, Short b) {
        return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b));
    }
    public BigDecimal shortMinus(Short a, Short b) {
        return BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b));
    }
    public BigDecimal shortMultiply(Short a, Short b) {
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b));
    }
    public BigDecimal shortDivide(Short a, Short b) {
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_UP);
    }
    public BigDecimal integerCompareTo(Integer a, Integer b) {
        return BigDecimal.valueOf(a).compareTo(BigDecimal.valueOf(b)) == 0 ? BigDecimal.valueOf(0) : BigDecimal.valueOf(1);
    }
    public BigDecimal doubleCompareTo(Double a, Double b) {
        return BigDecimal.valueOf(a).compareTo(BigDecimal.valueOf(b)) == 0 ? BigDecimal.valueOf(0) : BigDecimal.valueOf(1);
    }
    public BigDecimal floatCompareTo(Float a, Float b) {
        return BigDecimal.valueOf(a).compareTo(BigDecimal.valueOf(b)) == 0 ? BigDecimal.valueOf(0) : BigDecimal.valueOf(1);
    }
    public BigDecimal longCompareTo(Long a, Long b) {
        return BigDecimal.valueOf(a).compareTo(BigDecimal.valueOf(b)) == 0 ? BigDecimal.valueOf(0) : BigDecimal.valueOf(1);
    }
    public BigDecimal shortCompareTo(Short a, Short b) {
        return BigDecimal.valueOf(a).compareTo(BigDecimal.valueOf(b)) == 0 ? BigDecimal.valueOf(0) : BigDecimal.valueOf(1);
    }

    // y = ax + b
    public BigDecimal linearFunction(BigDecimal x, BigDecimal a, BigDecimal b) {
        return x.multiply(a).add(b);
    }
    // y = ax^2 + bx + c
    public BigDecimal quadraticFunction(BigDecimal x, BigDecimal a, BigDecimal b, BigDecimal c) {
        return x.pow(2).multiply(a).add(x.multiply(b)).add(c);
    }
    // y = ax^3 + bx^2 + cx + d
    public BigDecimal cubicFunction(BigDecimal x, BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d) {
        return x.pow(3).multiply(a).add(x.pow(2).multiply(b)).add(x.multiply(c)).add(d);
    }
    // y = x^a
    public BigDecimal powerFunction(BigDecimal x, BigDecimal a) {
        return x.pow(a.intValue());
    }
    // y = a^x
    public BigDecimal exponentialFunction(BigDecimal x, BigDecimal a) {
        return a.pow(x.intValue());
    }
    // y = log_a(x)
    public BigDecimal logarithmicFunction(BigDecimal x, BigDecimal a) {
        return BigDecimal.valueOf(Math.log(x.doubleValue()) / Math.log(a.doubleValue()));
    }
    // y = ln(x)
    public BigDecimal naturalLogarithmicFunction(BigDecimal x) {
        return BigDecimal.valueOf(Math.log(x.doubleValue()));
    }
    // y = x^(1/2)
    public BigDecimal squareRootFunction(BigDecimal x) {
        return BigDecimal.valueOf(Math.sqrt(x.doubleValue()));
    }
    // y = sin(x)
    public BigDecimal sineFunction(BigDecimal x) {
        return BigDecimal.valueOf(Math.sin(x.doubleValue()));
    }
    // y = cos(x)
    public BigDecimal cosineFunction(BigDecimal x) {
        return BigDecimal.valueOf(Math.cos(x.doubleValue()));
    }
    // y = tan(x)
    public BigDecimal tangentFunction(BigDecimal x) {
        return BigDecimal.valueOf(Math.tan(x.doubleValue()));
    }
    // y = cot(x)
    public BigDecimal cotangentFunction(BigDecimal x) {
        return BigDecimal.valueOf(1 / Math.tan(x.doubleValue()));
    }
}
