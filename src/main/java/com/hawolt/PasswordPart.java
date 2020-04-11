package com.hawolt;

/**
 * Created by: Niklas
 * Date: 10.02.2020
 * Time: 19:45
 */
public class PasswordPart {
    private PasswordCharset charset;
    private int min, max;

    public PasswordPart(PasswordCharset charset, int min, int max) {
        this.charset = charset;
        this.min = min;
        this.max = max;
    }

    public PasswordCharset getCharset() {
        return charset;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
