package com.hawolt.charset;

import java.util.HashSet;
import java.util.Set;

public abstract class PasswordCharset implements CharacterSet {
    private Set<Character> set = new HashSet<Character>();

    public final static PasswordCharset DIGIT_CHARSET = new PasswordCharset() {
        @Override
        protected int[][] getBounds() {
            return new int[][]{new int[]{48, 57}};
        }
    };

    public final static PasswordCharset LOWERCASE_CHARSET = new PasswordCharset() {
        @Override
        protected int[][] getBounds() {
            return new int[][]{new int[]{97, 122}};
        }
    };

    public final static PasswordCharset SPECIAL_CHARSET = new PasswordCharset() {
        @Override
        protected int[][] getBounds() {
            return new int[][]{new int[]{33, 47}, new int[]{58, 64}, new int[]{91, 96}, new int[]{123, 126}};
        }
    };

    public final static PasswordCharset UPPERCASE_CHARSET = new PasswordCharset() {
        @Override
        protected int[][] getBounds() {
            return new int[][]{new int[]{65, 90}};
        }
    };

    public PasswordCharset() {
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
