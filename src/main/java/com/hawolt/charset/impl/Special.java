package com.hawolt.charset.impl;

import com.hawolt.charset.AbstractCharset;

public class Special extends AbstractCharset {
    public int[][] getBounds() {
        return new int[][]{new int[]{33, 47}, new int[]{58, 64}, new int[]{91, 96}, new int[]{123, 126}};
    }
}
