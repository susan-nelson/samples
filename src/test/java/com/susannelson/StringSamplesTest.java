package com.susannelson;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.*;

public class StringSamplesTest {

    static final String INPUT = "Hello" + System.lineSeparator() + "How are you?" + System.lineSeparator() + "Bye";

    @Test
    public void testHasUniqueChars_true() throws Exception {

        assertTrue(StringSamples.hasUniqueChars("abcd"));
    }

    @Test
    public void testHasUniqueCharsForLocale_true() throws Exception {

        String original = "éDedCBcbAàa"; // sorted "aAàbBcCdDeé"
        assertTrue(StringSamples.hasUniqueCharsSortedByLocale(original, new Locale("fr", "FR")));
    }

    @Test
    public void testHasUniqueChars_false() throws Exception {

        assertFalse(StringSamples.hasUniqueChars("abcda"));
    }

    @Test
    public void testHasUniqueChars_moreThan128() throws Exception {

        assertFalse(StringSamples.hasUniqueChars(StringUtils.repeat(' ', StringSamples.NUM_ASCII_CHARS + 1)));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testHasUniqueChars_empty() throws Exception {

        StringSamples.hasUniqueChars("");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testHasUniqueChars_null() throws Exception {

        StringSamples.hasUniqueChars(null);
    }
    @Test
    public void testHasUniqueCharsSorted_true() throws Exception {

        assertTrue(StringSamples.hasUniqueCharsSorted("abcd"));
    }

    @Test
    public void testHasUniqueCharsSortedt_false() throws Exception {

        assertFalse(StringSamples.hasUniqueCharsSorted("abcda"));
    }

    @Test
    public void testHasUniqueCharsSorted_moreThan128() throws Exception {

        assertFalse(StringSamples.hasUniqueCharsSorted(StringUtils.repeat(' ', StringSamples.NUM_ASCII_CHARS + 1)));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testHasUniqueCharsSorted_empty() throws Exception {

        StringSamples.hasUniqueCharsSorted("");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testHasUniqueCharsSorted_null() throws Exception {

        StringSamples.hasUniqueCharsSorted(null);
    }

    @Test
    public void testHasUniqueStrings_true() throws Exception {

        String[] array = {"abcd", "efg", "h"};
        assertTrue(StringSamples.hasUniqueStrings(array));
    }

    @Test
    public void testHasUniqueStrings_false() throws Exception {

        String[] array = {"abcd", "efg", "abcd", "h"};
        assertFalse(StringSamples.hasUniqueStrings(array));
    }

    @Test
    public void testAppendCharacter() throws Exception {

        String append = "<";
        Character appendChar = append.charAt(0);

        String result = StringSamples.prependToLines(INPUT, append);

        if (System.lineSeparator().length() == 2) {

            assertTrue(result != null && result.length() == 27);
            assertTrue(result.charAt(0) == appendChar);
            assertTrue(result.charAt(8) == appendChar);
            assertTrue(result.charAt(23) == appendChar);
        } else {
            assertTrue(result != null && result.length() == 25);
            assertTrue(result.charAt(0) == appendChar);
            assertTrue(result.charAt(7) == appendChar);
            assertTrue(result.charAt(21) == appendChar);
        }

        System.out.println(result);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAppendCharacter_nullInput() throws Exception {

        StringSamples.prependToLines(null, "<");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAppendCharacter_nullAppend() throws Exception {

        StringSamples.prependToLines(INPUT, null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAppendCharacter_emptyInput() throws Exception {

        StringSamples.prependToLines("", "<");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAppendCharacter_emptyCR() throws Exception {

        StringSamples.prependToLines(System.lineSeparator(), "<");
    }

    @Test
    public void testReverseWithBuilder() {

        String reversible = "reversible";
        String expected = "elbisrever";

        String result = StringSamples.reverseWithBuilder(reversible);

        assertTrue(result != null && result.length() == reversible.length());
        assertTrue(result.equals(expected));
    }

    @Test
    public void testReverseWithBuilderReverse() {

        String reversible = "reversible";
        String expected = "elbisrever";

        String result = StringSamples.reverseWithBuilderReverse(reversible);

        assertTrue(result != null && result.length() == reversible.length());
        assertTrue(result.equals(expected));
    }

    @Test
    public void testReverseWithIteration() {

        String reversible = "reversible";
        String expected = "elbisrever";

        String result = StringSamples.reverseWithIteration(reversible);

        assertTrue(result != null && result.length() == reversible.length());
        assertTrue(result.equals(expected));
    }

    @Test
    public void testReverseWithRecursion() {

        String reversible = "reversible";
        String expected = "elbisrever";

        String result = StringSamples.reverseWithRecursion(reversible);

        assertTrue(result != null && result.length() == reversible.length());
        assertTrue(result.equals(expected));
    }

    @Test
    public void testReverseInPlace() {

        String reversible = "reversible";
        String expected = "elbisrever";

        String result = StringSamples.reverseInPlace(reversible);

        assertTrue(result != null);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testReverseInPlace_odd() {

        String reversible = "reverse";
        String expected = "esrever";

        String result = StringSamples.reverseInPlace(reversible);

        assertTrue(result != null);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testRotate() {

        String input = "rotate";
        String expected = "aterot";

        String result = StringSamples.rotate(input, 3);

        assertTrue(result != null);
        assertTrue(result.equals(expected));
    }

    @Test
    public void testRotate_odd() {

        String input = "rotatable";
        String expected = "tablerota";

        String result = StringSamples.rotate(input, 5);

        assertTrue(result != null);
        assertTrue(result.equals(expected));
    }
}