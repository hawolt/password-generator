package com.hawolt;

import com.hawolt.charset.CharacterSet;
import com.hawolt.charset.impl.Digit;
import com.hawolt.charset.impl.Lowercase;
import com.hawolt.charset.impl.Special;
import com.hawolt.charset.impl.Uppercase;

public enum ASCII {
    LOWERCASE(new Lowercase()),
    UPPERCASE(new Uppercase()),
    SPECIAL(new Special()),
    NUMBER(new Digit());

    private CharacterSet set;

    ASCII(CharacterSet set) {
        this.set = set;
    }

    public CharacterSet getSet() {
        return set;
    }
}
