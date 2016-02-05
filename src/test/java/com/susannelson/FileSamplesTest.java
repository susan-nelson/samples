package com.susannelson;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URISyntaxException;
import java.util.*;

import static org.testng.Assert.*;

public class FileSamplesTest {

    FileSamples classUnderTest;

    @BeforeMethod
    public void setUp() {
        classUnderTest = new FileSamples();
    }

    @Test
    public void testSortFileRecordsBySecondField() {

        classUnderTest.sortFileRecordsBySecondField();

        assertTrue(true);
    }

    @Test
    public void testReadFileWithJava8Stream() throws URISyntaxException {

        classUnderTest.readFileWithJava8Stream();

        assertTrue(true);
    }

    @Test
    public void testSortBySecondField() throws Exception {

        List<String> lines = new ArrayList<>();
        lines.add("Jervie,12,M");
        lines.add("Jaimy,11,F");
        lines.add("Tony,23,M");
        lines.add("Janey,11,F");

        Integer[] keys = {11,12,23};

        Map<Integer, Set<String>> sorted = classUnderTest.sortBySecondField(lines);

        assertTrue(sorted != null);
        assertTrue(sorted.size() == 3);

        Set<Integer> sortedKeySet = sorted.keySet();

        assertEquals(sortedKeySet.toArray(), keys);

        Iterator<Integer> it = sortedKeySet.iterator();

        Integer key = it.next();
        Set<String> sortedLines = sorted.get(key);

        assertEquals(sortedLines.size(), 2);

        key = it.next();
        sortedLines = sorted.get(key);

        assertEquals(sortedLines.size(), 1);

        key = it.next();
        sortedLines = sorted.get(key);

        assertEquals(sortedLines.size(), 1);
    }
}