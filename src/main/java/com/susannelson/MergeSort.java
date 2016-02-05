package com.susannelson;

import java.util.Arrays;

/**
 * http://codereview.stackexchange.com/questions/64711/merge-sort-an-integer-array
 */
public class MergeSort {

    public static void mergeSort(int[] inputArray) {

        int size = inputArray.length;
        if (size < 2)
            return;
        int mid = size / 2;
        int leftSize = mid;
        int[] left = Arrays.copyOfRange(inputArray, 0, leftSize);
        int[] right = Arrays.copyOfRange(inputArray, leftSize, inputArray.length);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, inputArray);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < leftSize) {
            arr[k++] = left[i++];
        }
        while (j < rightSize) {
            arr[k++] = right[j++];
        }
    }
}

