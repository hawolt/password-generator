package com.hawolt.charset.impl;

import com.hawolt.charset.AbstractCharset;

public class Uppercase extends AbstractCharset {
    public int[][] getBounds() {
        return new int[][]{new int[]{65, 90}};
    }
}
