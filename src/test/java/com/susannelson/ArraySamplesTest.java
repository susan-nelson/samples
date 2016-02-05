package com.susannelson;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySamplesTest {


    @Test
    public void testGetIntersection() {

        String match = "second";
        String[] firstArray = {"first", match};
        String[] secondArray = {match};

        String[] result = ArraySamples.getIntersection(firstArray, secondArray);

        assertTrue(result != null && result.length == 1);
        assertTrue(result[0].equals(match));
    }

    @Test
    public void testGetIntersection2() {

        String match = "second";
        String[] secondArray = {"first", match};
        String[] firstArray = {match};

        String[] result = ArraySamples.getIntersection(firstArray, secondArray);

        assertTrue(result != null && result.length > 0);
        assertTrue(result[0].equals(match));
    }

    @Test
    public void testGetIntersectionOfChars() {

        char[] firstArray = {'b', 'a', 'c'};
        char[] secondArray = {'a', 'c'};

        char[] result = ArraySamples.getIntersectionOfChars(firstArray, secondArray);

        assertTrue(result.length == 2);
        assertTrue(result[0] == 'a');
        assertTrue(result[1] == 'c');
    }

    @Test
    public void testGetIntersectionOfChars2() {

        char[] secondArray = {'b', 'a', 'c'};
        char[] firstArray = {'a', 'c'};

        char[] result = ArraySamples.getIntersectionOfChars(firstArray, secondArray);

        assertTrue(result.length == 2);
        assertTrue(result[0] == 'a');
        assertTrue(result[1] == 'c');
    }

    @Test
    public void testGetIntersectionOfChars3() {

        char[] secondArray = {'b', 'a', 'c'};
        char[] firstArray = {'a', 'c', 'c'};

        char[] result = ArraySamples.getIntersectionOfChars(firstArray, secondArray);

        assertTrue(result.length == 2);
        assertTrue(result[0] == 'a');
        assertTrue(result[1] == 'c');
    }

    @Test
    public void testGetIntersectionOfInts() {

        int[] firstArray = {2, 1, 3};
        int[] secondArray = {1, 3};

        int[] result = ArraySamples.getIntersectionOfInts(firstArray, secondArray);

        assertTrue(result.length == 2);
        assertTrue(result[0] == 1);
        assertTrue(result[1] == 3);
    }

    @Test
    public void testGetIntersectionOfInts2() {

        int[] secondArray = {2, 1, 3};
        int[] firstArray = {1, 3};

        int[] result = ArraySamples.getIntersectionOfInts(firstArray, secondArray);

        assertTrue(result.length == 2);
        assertTrue(result[0] == 1);
        assertTrue(result[1] == 3);
    }

    @Test
    public void testGetIntersectionOfInts_withDuplicates() {

        int[] secondArray = {2, 1, 1, 3};
        int[] firstArray = {1, 1, 3};

        int[] result = ArraySamples.getIntersectionOfInts(firstArray, secondArray);

        assertEquals(result.length, 2);
        assertEquals(result[0], 1);
        assertEquals(result[1], 3);
    }
}