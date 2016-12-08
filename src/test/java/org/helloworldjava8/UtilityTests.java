package org.helloworldjava8;

import org.junit.Test;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.helloworldjava8.Utility.countLongWords;

/**
 * Demonstrates junit and hamcrest matcher usage
 */
public class UtilityTests {

    @Test
    public void countLongWordsEmptyString() {
        assertThat(countLongWords(""), is(0L));
    }

    @Test
    public void countLongWordsSingleShortWord() {
        assertThat(countLongWords("a"), is(0L));
        assertThat(countLongWords("at"), is(0L));
        assertThat(countLongWords("the a at"), is(0L));
    }

    @Test
    public void countLongWordsShortAndLongMixed() {
        assertThat(countLongWords("A long day"), is(1L));
        assertThat(countLongWords("It is a windy cloudy day"), is(2L));
        assertThat(countLongWords("tour pizza cats"), is(3L));
    }

    @Test
    public void countLongWordsOnly() {
        assertThat(countLongWords("house cars blue tree"), is(4L));
    }

    @Test
    public void daysBetweenDates() {
        assertThat(Utility.daysBetween(LocalDate.of(2016, 1, 1),
            LocalDate.of(2016, 1, 5)), is(4));

        // Works in reverse
        assertThat(Utility.daysBetween(LocalDate.of(2016, 1, 5),
            LocalDate.of(2016, 1, 1)), is(4));

        assertThat(Utility.daysBetween(LocalDate.of(2016, 3, 30),
            LocalDate.of(2016, 4, 5)), is(6));
    }

    @Test
    public void parseIntToOptional(){
        assertThat(Utility.parseIntegerOptional("3").get(), is(3));

        assertThat(Utility.parseIntegerOptional("three").isPresent(),
            is(false));
    }

    @Test(expected=NoSuchElementException.class)
    public void parseIntToOptionalException() {
        Utility.parseIntegerOptional("wow").get();
    }

}
