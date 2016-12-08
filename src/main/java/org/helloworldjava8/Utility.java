package org.helloworldjava8;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Optional;

public class Utility {

    /**
     * Counts words with length greater than 3
     * Demonstrates the stream interface and lambda expressions
     *
     * @return number of long words in string
     */
    public static long countLongWords(String input) {
        return Arrays.asList(input.split(" ")).
            stream().filter(w -> w.length() > 3).count();
    }

    /**
     * Demonstrates usage of the new Java 8 Time classes
     * @param from
     * @param to
     * @return
     */
    public static int daysBetween(LocalDate from, LocalDate to){
        return Math.abs(Period.between(from, to).getDays());
    }

    /**
     * Demonstrates new Optional utility
     * @param input
     * @return
     */
    public static Optional<Integer> parseIntegerOptional(String input) {
        try {
            return Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }
    }

}
