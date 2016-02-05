package com.dev9.susannelson;

import java.util.ArrayList;
import java.util.List;

/**
 * Functions for Nintendo prescreen.
 * Assumption: restricted to using JDK only.
 */
public class NintendoPrescreen {

    /**
     * 1a. Converts a string to integer and returns it as an int.
     * If the string is null or empty or only contains spaces, returns 0 (similar to apache commons NumberUtils).
     * @param input - the String to convert
     * @see Integer#parseInt(String)
     * @throws NumberFormatException if the String is not accepted by Integer.parseInt().
     */
    public int convertToInt(final String input) {

        if (input == null) {

            return 0;
        }

        String trimmedString = input.trim();

        if (trimmedString.isEmpty()) {

            return 0;
        }

        return Integer.parseInt(trimmedString);
    }

    /**
     * 1b. Finds longest palindrome in a string and return that palindrome as a string.
     *
     * Definition from Wikipedia: A palindrome is a word, phrase, number, or other sequence of characters which
     * reads the same backward or forward. Allowances may be made for adjustments to capital letters, punctuation,
     * and word dividers.
     *
     * This will handle palindromes such as 'A man, a plan, a canal, Panama!'. It is possible that the beginning
     * of a palindrome could begin within another palindrome.
     *
     * In a loop that tests each substring starting with two characters from index 0, if the substring does not
     * constitute a palindrome, a character from  next position is added to the substring and tested again.
     * This continues until the end of the String or when a palindrome is found. If a palindrome is found
     * and it is longer than any others found, it is saved. The rest of String is tested to see
     * if there is a longer palindrome containing the found palindrome. At the end of the String,
     * the starting position of subsequent searches is adjusted +1 and the process of finding palindromes continues.
     *
     * @param input - the String with possible palindrome(s)
     * @return the longest palindrome found or an empty String if the input is null or empty or no palindromes were found.
     */
    public String findLongestPalindrome(final String input) {

        String longestPalindrome = "";

        if (input != null) {

            int indexStart = 0;
            int indexEnd;

            int maxLength = input.length();
            int subStringLength;
            String subString;

            for (subStringLength = 2; subStringLength <= maxLength; subStringLength++) {

                indexEnd = indexStart + subStringLength;

                subString = input.substring(indexStart, indexEnd);

                if (isPalindrome(subString)){

                    if (subString.trim().length() > longestPalindrome.length()){

                        longestPalindrome = subString.trim();
                    }
                }

                //at end of input, continue scanning text from the end of the latest palindrome
                if (subStringLength == maxLength && indexStart < input.length() - 1){

                    indexStart++;
                    subStringLength = 0;
                    maxLength = input.length() - indexStart;
                }
            }
        }

        return longestPalindrome;
    }
    /**
     * 1c. Given two Lists, find values in the first list that are not in the second list and return those values in a third list.
     *
     * @param firstList - a List of Strings
     * @param secondList - a List of Strings
     */
    public List<String> findItemsNotInFirstList(final List<String> firstList, final List<String> secondList) {

        assert firstList != null;
        assert secondList != null;

        List<String> thirdList = new ArrayList<String>();

        for (String listItem : firstList) {

            if (!secondList.contains(listItem)) {

                thirdList.add(listItem);
            }
        }

        return thirdList;
    }

    /**
     * Returns true if the parameter String is a palindrome.
     *
     * Cleans the String to remove everything but alphanumerics. Reverses the String and returns true
     * if the reversed String is equal to the original String.
     *
     * @param aString - the possible palindrome.
     * @return boolen
     */
    private boolean isPalindrome(final String aString) {

        if (aString == null || aString.length() < 2) {

            return false;
        }

        String cleanString = aString.toLowerCase().replaceAll("[^a-z0-9]", "");

        if (cleanString.length() < 2) {

            return false;
        }

        String reversed = new StringBuilder(cleanString).reverse().toString();

        return reversed.equals(cleanString);
    }
}
