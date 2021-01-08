package com.hawolt;

import com.hawolt.charset.CharacterSet;

import java.util.ArrayList;
import java.util.List;

public class Configuration {

    private Builder builder;

    private Configuration(Builder builder) {
        this.builder = builder;
    }

    public Builder getBuilder() {
        return builder;
    }

    public int getMinimumLength() {
        return builder.minimumLength;
    }

    public int getMaximumLength() {
        return builder.maximumLength;
    }

    public int getFixedLength() {
        return builder.fixedLength;
    }

    public List<CharacterSet> getList() {
        return builder.list;
    }

    public boolean isShuffle() {
        return builder.shuffle;
    }

    public Generator createGenerator() {
        return new Generator(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private int minimumLength, maximumLength, fixedLength;
        private List<CharacterSet> list;
        private boolean shuffle;

        private Builder() {
            this.list = new ArrayList<CharacterSet>();
        }

        public Builder addCharacterSet(ASCII ascii) {
            list.add(ascii.getSet());
            return this;
        }

        public Builder addCharacterSet(CharacterSet set) {
            list.add(set);
            return this;
        }

        public Builder setMinimumLength(int minimumLength) {
            this.minimumLength = minimumLength;
            return this;
        }

        public Builder setMaximumLength(int maximumLength) {
            this.maximumLength = maximumLength;
            return this;
        }

        public Builder setFixedLength(int fixedLength) {
            this.fixedLength = fixedLength;
            return this;
        }

        public Builder setShuffle(boolean shuffle) {
            this.shuffle = shuffle;
            return this;
        }

        public Configuration build() {
            return new Configuration(this);
        }
    }
}
