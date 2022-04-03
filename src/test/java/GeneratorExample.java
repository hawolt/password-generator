import com.hawolt.ASCII;
import com.hawolt.Configuration;
import com.hawolt.Generator;
import com.hawolt.charset.PasswordCharset;

public class GeneratorExample {

    public static void main(String[] args) {
        /*
         * Defining a custom Charset for the Generator
         */
        PasswordCharset charset = new PasswordCharset() {
            @Override
            protected int[][] getBounds() {
                return new int[][]{new int[]{48, 57}};
            }
        };

        /*
         * Initializing a Generator using the Configuration Builder
         */
        Generator generator = Configuration.builder()
                .addCharacterSet(ASCII.UPPERCASE)
                .addCharacterSet(ASCII.LOWERCASE)
                .addCharacterSet(ASCII.SPECIAL)
                .addCharacterSet(charset)
                .setMinimumLength(7)
                .setMaximumLength(13)
                .setShuffle(true)
                .build()
                .createGenerator();

        /*
         * Generate a password matching the Configuration
         */
        String password = generator.generate();
    }
}
