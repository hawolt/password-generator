package com.hawolt;

import com.hawolt.charset.CharacterSet;
import com.hawolt.charset.PasswordCharset;

public enum ASCII {
    LOWERCASE(PasswordCharset.LOWERCASE_CHARSET),
    UPPERCASE(PasswordCharset.UPPERCASE_CHARSET),
    SPECIAL(PasswordCharset.SPECIAL_CHARSET),
    NUMBER(PasswordCharset.DIGIT_CHARSET);

    private final CharacterSet set;

    ASCII(CharacterSet set) {
        this.set = set;
    }

    public CharacterSet getSet() {
        return set;
    }
}
