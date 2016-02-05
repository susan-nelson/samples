package com.dev9.susannelson;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Class for unit testing NintendoPrescreen.
 * Dependant on TestNG.
 */
public class NintendoPrescreenTest {

    private NintendoPrescreen classUnderTest;

    @BeforeClass
    public void setup() {

        classUnderTest = new NintendoPrescreen();
    }

    @Test
    public void convertToInt() throws Exception {

        int convertedFromString = classUnderTest.convertToInt("123");

        assertEquals(convertedFromString, 123);
    }

    @Test
    public void convertToInt_Null() throws Exception {

        int convertedFromString = classUnderTest.convertToInt(null);

        assertEquals(convertedFromString, 0);
    }

    @Test
    public void convertToInt_Empty() throws Exception {

        int convertedFromString = classUnderTest.convertToInt("");

        assertEquals(convertedFromString, 0);
    }

    @Test
    public void convertToInt_Space() throws Exception {

        int convertedFromString = classUnderTest.convertToInt(" ");

        assertEquals(convertedFromString, 0);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void convertToInt_Invalid() throws Exception {

        classUnderTest.convertToInt("a6c ");
    }

    @Test
    public void findLongestPalindrome_OnePalindromeWithSpacesAndPunctuation() throws Exception {

        String thePalindrome = "Was it a car or a cat I saw?";

        String longestPalindrome = classUnderTest.findLongestPalindrome(thePalindrome);

        assertEquals(longestPalindrome, thePalindrome);
    }

    @Test
    public void findLongestPalindrome_TwoPalindromes_SecondLonger() throws Exception {

        String firstPalindrome = "abcba";
        String nonPalindrome = " dbcde ";
        String secondPalindrome = "aabbaa";
        String thePalindromes = firstPalindrome + nonPalindrome + secondPalindrome;

        String longestPalindrome = classUnderTest.findLongestPalindrome(thePalindromes);

        assertEquals(longestPalindrome, secondPalindrome);
    }

    @Test
    public void findLongestPalindrome_ThreePalindromes_SecondLonger() throws Exception {

        String firstPalindrome = "A man, a plan, a canal, Panama!";
        String secondPalindrome = "dbcbd";
        String thirdPalindrome = "aabbaa";
        String thePalindromes = firstPalindrome + secondPalindrome + thirdPalindrome;

        String longestPalindrome = classUnderTest.findLongestPalindrome(thePalindromes);

        assertEquals(longestPalindrome, firstPalindrome);
    }

    @Test
    public void findLongestPalindrome_ThreePalindromes_FirstLonger() throws Exception {

        String firstPalindrome = "A man, a plan, a canal, Panama!";
        String secondPalindrome = "dbcbd";
        String thirdPalindrome = "aabbaa";
        String thePalindromes = firstPalindrome + secondPalindrome + thirdPalindrome;

        String longestPalindrome = classUnderTest.findLongestPalindrome(thePalindromes);

        assertEquals(longestPalindrome, firstPalindrome);
    }

    @Test
    public void findLongestPalindrome_ThreePalindromes_SecondLonger_Nested() throws Exception {

        String nonPalindrome = " abcde ";
        String firstPalindrome = "dbcbd";
        String secondPalindromeNested = "dbcb";
        String nonPalindrome2 = " cb ";
        String thirdPalindrome = "aabbaa";
        String thePalindromes = nonPalindrome + firstPalindrome + secondPalindromeNested + nonPalindrome2 + thirdPalindrome;

        String longestPalindrome = classUnderTest.findLongestPalindrome(thePalindromes);

        assertEquals(longestPalindrome, "bcbddbcb");
    }

    @Test
    public void findLongestPalindrome_TooShort() throws Exception {

        String longestPalindrome = classUnderTest.findLongestPalindrome("a");

        assertEquals(longestPalindrome, "");
    }

    @Test
    public void findLongestPalindrome_Empty() throws Exception {

        String longestPalindrome = classUnderTest.findLongestPalindrome("");

        assertEquals(longestPalindrome, "");
    }

    @Test
    public void findLongestPalindrome_Null() throws Exception {

        String longestPalindrome = classUnderTest.findLongestPalindrome(null);

        assertEquals(longestPalindrome, "");
    }

    @Test
    public void findItemsNotInFirstList() throws Exception {

        String firstListOnly = "First List Only";
        String secondListOnly = "Second List Only";
        String bothLists = "Both Lists";
        List<String> firstList = new ArrayList<String>();
        firstList.add(firstListOnly);
        firstList.add(bothLists);
        List<String> secondList = new ArrayList<String>();
        secondList.add(secondListOnly);
        secondList.add(bothLists);

        List<String> thirdList = classUnderTest.findItemsNotInFirstList(firstList, secondList);

        assertEquals(thirdList.size(), 1);
        assertEquals(thirdList.get(0), firstListOnly);
    }

    @Test
    public void findItemsNotInFirstList_emptyLists() throws Exception {

        List<String> firstList = new ArrayList<String>();
        List<String> secondList = new ArrayList<String>();
        List<String> thirdList = classUnderTest.findItemsNotInFirstList(firstList, secondList);

        assertEquals(thirdList.size(), 0);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void findItemsNotInFirstList_NullLists() throws Exception {

        classUnderTest.findItemsNotInFirstList(null, null);
    }

}