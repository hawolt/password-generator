package com.hawolt.charset.impl;

import com.hawolt.charset.AbstractCharset;

public class Lowercase extends AbstractCharset {
    public int[][] getBounds() {
        return new int[][]{new int[]{97, 122}};
    }
}
