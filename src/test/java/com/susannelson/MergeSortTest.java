package com.susannelson;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * Created by Susan on 12/22/2015.
 */
public class MergeSortTest {

    @Test
    public void reverseInput(){
        int[] arr={22,21,19,18,15,14,9,7,5};
        MergeSort.mergeSort(arr);
        assertEquals("[5, 7, 9, 14, 15, 18, 19, 21, 22]", Arrays.toString(arr));

    }
    @Test
    public void emptyInput(){
        int[] arr={};
        MergeSort.mergeSort(arr);
        assertEquals("[]", Arrays.toString(arr));
    }

    @Test
    public void alreadySorted(){
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        MergeSort.mergeSort(arr);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(arr));
    }
}