package com.hawolt.charset;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractCharset implements CharacterSet {
    private Set<Character> set = new HashSet<Character>();

    public AbstractCharset() {
        int[][] bounds = getBounds();
        for (int i = 0; i < bounds.length; i++) {
            int[] range = bounds[i];
            int start = range[0], end = range[1];
            for (int j = start; j <= end; j++) {
                set.add((char) j);
            }
        }
    }

    protected abstract int[][] getBounds();

    public Set<Character> getSet() {
        return set;
    }
}
