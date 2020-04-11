package com.hawolt;

/**
 * Created by: Niklas
 * Date: 10.02.2020
 * Time: 19:43
 */
public enum PasswordCharset {
    NUMBER(48, 57),
    SPECIAL(33, 45),
    UPPERCASE(65, 90),
    LOWERCASE(97, 122);
    private int lower, upper;

    PasswordCharset(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }
}
