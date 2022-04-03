package com.hawolt;

import com.hawolt.charset.CharacterSet;

import java.security.SecureRandom;
import java.util.Random;

public class Generator {
    private final Configuration configuration;
    private final Random random;
    private char[] set;

    public Generator(Configuration configuration) {
        this.configuration = configuration;
        this.random = new SecureRandom();
        this.set = new char[0];
        this.build();
    }

    private void build() {
        for (CharacterSet set : configuration.getList()) {
            this.set = extend(this.set, set.getSet().toArray(new Character[0]));
        }
        shuffle(set);
    }

    public String generate() {
        int length;
        if (configuration.getFixedLength() > 0) {
            length = configuration.getFixedLength();
        } else {
            length = random.nextInt(configuration.getMaximumLength() - configuration.getMinimumLength()) + configuration.getMinimumLength();
        }
        char[] characters = new char[length];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = set[random.nextInt(set.length)];
        }
        if (configuration.isShuffle()) shuffle(characters);
        return new String(characters);
    }

    private void shuffle(char[] array) {
        int index;
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            if (index != i) {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }

    private char[] extend(char[] original, Character[] extension) {
        char[] tmp = new char[original.length + extension.length];
        for (int i = 0; i < original.length; i++) {
            tmp[i] = original[i];
        }
        for (int i = 0; i < extension.length; i++) {
            tmp[original.length + i] = extension[i];
        }
        return tmp;
    }
}


