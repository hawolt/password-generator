package com.hawolt.charset.impl;

import com.hawolt.charset.AbstractCharset;

public class Digit extends AbstractCharset {
    public int[][] getBounds() {
        return new int[][]{new int[]{48, 57}};
    }
}
