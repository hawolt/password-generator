package com.hawolt;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by: Niklas
 * Date: 24.03.2020
 * Time: 18:47
 */
public class PasswordGenerator {
    private static final Random RANDOM = new SecureRandom();

    private static Stream<Character> get(int count, int start, int end) {
        IntStream stream = RANDOM.ints(count, start, end);
        return stream.mapToObj(data -> (char) data);
    }

    public static String getPassword(boolean mix, PasswordPart... parts) {
        Stream<Character> streams = Optional.of(Arrays.stream(parts).map(PasswordGenerator::get)).orElseGet(Stream::empty).reduce(Stream::concat).orElseGet(Stream::empty);
        List<Character> list = streams.collect(Collectors.toList());
        if (mix) Collections.shuffle(list);
        return list.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }


    private static Stream<Character> get(PasswordPart part) {
        int tmp = part.getMax() - part.getMin();
        int amount = tmp <= 0 ? part.getMin() : RANDOM.nextInt(tmp + 1) + part.getMin();
        if (amount <= 0) return Stream.empty();
        IntStream stream = RANDOM.ints(amount, part.getCharset().getLower(), part.getCharset().getUpper());
        return stream.mapToObj(data -> (char) data);
    }

    static String getPassword() {
        Stream<Character> streams = Stream.concat(get(RANDOM.nextInt(5) + 1, 48, 57), Stream.concat(get(RANDOM.nextInt(2) + 1, 33, 45), Stream.concat(get(RANDOM.nextInt(5) + 4, 65, 90), get(RANDOM.nextInt(5) + 4, 97, 122))));
        List<Character> list = streams.collect(Collectors.toList());
        Collections.shuffle(list);
        return list.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

}
