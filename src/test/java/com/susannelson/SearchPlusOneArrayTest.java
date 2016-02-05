package com.susannelson;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Susan on 12/31/2015.
 */
public class SearchPlusOneArrayTest {

    @Test
    public void testSearchArray() throws Exception {

        SearchPlusOneArray classUnderTest = new SearchPlusOneArray();
        int arr[]={4,5,6,5,4,3,2,3,4,5,6,7,8};
        int pos=classUnderTest.searchArray(arr, 7);

        assertEquals(11, pos);
    }

    @Test
    public void testSearchArray_lessThan() throws Exception {

        SearchPlusOneArray classUnderTest = new SearchPlusOneArray();
        int arr[]={4,5,6,5,4,3,2,3,4,5,6,7,8};
        int pos=classUnderTest.searchArray(arr, 3);

        assertEquals(5, pos);
    }

    @Test
    public void testSearchArray_first() throws Exception {

        SearchPlusOneArray classUnderTest = new SearchPlusOneArray();
        int arr[]={4,5,6,5,4,3,2,3,4,5,6,7,8};
        int pos=classUnderTest.searchArray(arr, 4);

        assertEquals(0, pos);
    }


    @Test
    public void testSearchArray_notfound() throws Exception {

        SearchPlusOneArray classUnderTest = new SearchPlusOneArray();
        int arr[]={4,5,6,5,4,3,2,3,4,5,6,7,8};
        int pos=classUnderTest.searchArray(arr, 1);

        assertEquals(-1, pos);
    }

    @Test
    public void testSearchArray_descending() throws Exception {

        SearchPlusOneArray classUnderTest = new SearchPlusOneArray();
        int arr[]={4,3,2,3,4,5,6,7};
        int pos=classUnderTest.searchArray(arr, 3);

        assertEquals(1, pos);
    }

    @Test
    public void testSearchArray_descending_greaterThan() throws Exception {

        SearchPlusOneArray classUnderTest = new SearchPlusOneArray();
        int arr[]={7,6,5,4,3,2,1,2,1,2,3,4,5,6,7,8};
        int pos=classUnderTest.searchArray(arr, 8);

        assertEquals(15, pos);
    }
}