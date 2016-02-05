package com.susannelson;

import org.apache.commons.lang3.time.StopWatch;

import java.text.Collator;
import java.util.*;

public class StringSamples {

    public static final int NUM_ASCII_CHARS = 128;
    public static final boolean OS_WITH_TWO_CHAR_LINE_SEPARATOR = System.lineSeparator().length() == 2;

    /**
     * Search through each character in the String and return false when duplicate found.
     * (Assuming ascii) If the string is longer than 128 characters, returns false.
     * Uses additional data structure to collect found characters. We could sort the string first but that would
     * take time.
     * @param sampleString - the string to test
     * @return true if all characters in the String are unique
     * @throws IllegalArgumentException if input is null or empty
     */
    public static boolean hasUniqueChars(String sampleString) {

        if (sampleString == null || sampleString.length() == 0) {
            throw new IllegalArgumentException("bad input");
        }

        if (sampleString.length() > NUM_ASCII_CHARS) {
            return false;
        }

        StopWatch clock = new StopWatch();
        clock.start();

        Set<Character> foundChars = new HashSet<>(sampleString.length());

        for (int i = 0; i < sampleString.length(); i++) {

            if (!foundChars.add(sampleString.charAt(i))) {

                return false;
            }
        }

        clock.stop();
        System.out.println("Unsorted took " + clock.getNanoTime());

        return true;
    }

    /**
     * Return false if duplicate characters are found.
     * (Assuming ascii) If the string is longer than 128 characters, returns false.
     * Uses additional Set data structure to collect unique characters. If the size of the Set is less than the length
     * of the String, return false.
     * @param sampleString - the string to test
     * @return true if all characters in the String are unique
     * @throws IllegalArgumentException if input is null or empty
     */
    public static boolean hasUniqueStrings(String[] sampleString) {

        if (sampleString == null || sampleString.length == 0) {
            throw new IllegalArgumentException("bad input");
        }

        if (sampleString.length > NUM_ASCII_CHARS) {
            return false;
        }

        Set<String> foundChars = new HashSet<>(Arrays.asList(sampleString));

        return sampleString.length == foundChars.size();
    }

    /**
     * Sorts the characters in the string and then searches through each character and return false when adjacent
     * characters are duplicates.
     * (Assuming ascii) If the string is longer than 128 characters, returns false.
     * Uses an additional data structure for the sort.
     * @param sampleString - the string to test
     * @return true if all characters in the String are unique
     * @throws IllegalArgumentException if input is null or empty
     */
    public static boolean hasUniqueCharsSorted(String sampleString) {

        if (sampleString == null || sampleString.length() == 0) {
            throw new IllegalArgumentException("bad input");
        }

        if (sampleString.length() > NUM_ASCII_CHARS) {
            return false;
        }

        StopWatch clock = new StopWatch();
        clock.start();

        char[] sorted = sampleString.toCharArray();
        Arrays.sort(sorted);
        clock.stop();
        System.out.println("Sort took " + clock.getNanoTime());
        clock.reset();
        clock.start();
        for (int i = 1; i < sorted.length; i++) {

            if (sorted[i - 1] == sorted[i]) {

                return false;
            }
        }

        clock.stop();
        System.out.println("Sorted took " + clock.getNanoTime());

        return true;
    }

    /**
     * Sorts the characters in the string and then searches through each character and return false when adjacent
     * characters are duplicates.
     * (Assuming ascii) If the string is longer than 128 characters, returns false.
     * Uses an additional data structure for the sort.
     * Note: this may not work with split 32bit code points in two - Unicode characters with a value greater than 0xFFFF,
     * creating strings with invalid values
     * @param sampleString - the string to test
     * @return true if all characters in the String are unique
     * @throws IllegalArgumentException if input is null or empty
     */
    public static boolean hasUniqueCharsSortedByLocale(String sampleString, Locale loc) {

        if (sampleString == null || sampleString.length() == 0) {
            throw new IllegalArgumentException("bad input");
        }

        if (sampleString.length() > NUM_ASCII_CHARS) {
            return false;
        }

        Collator collator = Collator.getInstance(loc);
        StopWatch clock = new StopWatch();
        clock.start();

        String[] split = sampleString.split("");
        Arrays.sort(split, collator);

        for (int i = 1; i < split.length; i++)
        {
            if (split[i - 1].equals(split[i])) {

                return false;
            }
        }

        clock.stop();
        System.out.println("Sorted wit Locale took " + clock.getNanoTime());

        return true;
    }

    public static String prependToLines(String input, String append) {

        if (input == null || input.isEmpty() || append == null) {
            throw new IllegalArgumentException("bad input");
        }

        if (input.length() == 1 && input.charAt(0) == System.lineSeparator().charAt(0)) {
            throw new IllegalArgumentException("bad input");
        }


        if (OS_WITH_TWO_CHAR_LINE_SEPARATOR && input.length() == 2
                && input.charAt(0) == System.lineSeparator().charAt(0)
                && input.charAt(1) == System.lineSeparator().charAt(1)) {

            throw new IllegalArgumentException("bad input");
        }

        StringBuilder builder = new StringBuilder();
        builder.append(append);

        for (int i = 0; i < input.length(); i++) {

            builder.append(input.charAt(i));

            //if we are at the end of a line but not at the end of the String, append the character
            if (i < (input.length() - 1)) {

                if (input.charAt(i) == System.lineSeparator().charAt(0)) {

                    if (OS_WITH_TWO_CHAR_LINE_SEPARATOR
                            && input.charAt(i + 1) == System.lineSeparator().charAt(1)) {

                        builder.append(input.charAt(++i));
                    }

                    builder.append(append);
                }
            }
        }

        return builder.toString();
    }

    public static String reverseWithBuilderReverse(String theString) {

        StringBuilder builder = new StringBuilder(theString);

        return builder.reverse().toString();
    }

    public static String reverseWithBuilder(String theString) {

        StringBuilder builder = new StringBuilder(theString.length());

        for (int i = theString.length() - 1; i >= 0; i--) {
            builder.append(theString.charAt(i));
        }

        return builder.toString();
    }

    public static String reverseWithIteration(String theString) {

        StringBuilder builder = new StringBuilder(theString.length());

        for (int i = theString.length() - 1; i >= 0; i--) {
            builder.append(theString.charAt(i));
        }

        return builder.toString();
    }

    public static String reverseInPlace(final String theString) {

        //Turn the string into an array of characters so we don't
        //keep rebuilding immutable strings as we reverse the
        //string contents.
        char[] theChars = theString.toCharArray();
        int end = theString.length() - 1;
        int middle = theString.length()/2;

        //Advance from the beginning to the middle of the array.
        //Swap the current index (i) from the left side of the
        //array with the one equally distant from the end of the
        //right side (end).
        for (int i = 0; i < middle; i++, end--) {

            theChars[i] = theString.charAt(end);
            theChars[end] = theString.charAt(i);
        }

        //Turn the array back into a string and return it as
        //the result.
        return new String(theChars);
    }

    public static String reverseWithRecursion(String theString) {

        if (theString == null || theString.length() < 2) {
            return theString;
        }

        return reverse(theString);
    }

    public static String rotate(String input, int distance) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("bad input");
        }

        if (distance == 0) {
            return input;
        }

        char[] result = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            result[(i + distance) % input.length()] = input.charAt(i);
        }

        return new String(result);
    }

    private static String reverse(String str) {

        if (str.length() <= 1) {
            return str;
        }

        return reverse(str.substring(1)) + str.charAt(0);
    }
}
