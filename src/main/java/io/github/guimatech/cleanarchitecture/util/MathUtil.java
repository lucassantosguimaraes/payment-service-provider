package io.github.guimatech.cleanarchitecture.util;

public class MathUtil {

    private MathUtil(){}

    public static double getValueDiscount(double value, double percentage) {
        return value * (percentage / 100);
    }
}
