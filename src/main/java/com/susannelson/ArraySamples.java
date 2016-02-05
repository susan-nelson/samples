package com.susannelson;

import com.google.common.primitives.Ints;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class ArraySamples {

    public static String[] getIntersection(String[] firstArray, String[] secondArray) {

        String[] intersection = new String[firstArray.length > secondArray.length ? secondArray.length : firstArray.length];
        Set<String> firstSet = new HashSet<>(Arrays.asList(firstArray));
        int index = 0;

        for (String theString: secondArray) {

            if (firstSet.contains(theString)) {

                intersection[index++] = theString;
            }
        }

        return intersection;
    }

    public static char[] getIntersectionOfChars(char[] firstArray, char[] secondArray) {

        StringBuilder intersection = new StringBuilder(firstArray.length);
        boolean[] charSet = new boolean[128];
        Arrays.fill(charSet, false);

        for (char theChar : firstArray) {

            charSet[(int)theChar] = true;
        }

        for (char theChar : secondArray) {

            if (charSet[(int)theChar]) {

                intersection.append(theChar);
            }
        }

        return intersection.toString().toCharArray();
    }

    public static int[] getIntersectionOfInts(int[] firstArray, int[] secondArray) {

        Set<Integer> intersection = new TreeSet<>();
        Set<Integer> intersectSet = new HashSet<>(Arrays.asList(ArrayUtils.toObject(firstArray)));

        for (int secondArrayInt : secondArray) {

            if (!intersectSet.add(secondArrayInt)) {

                intersection.add(secondArrayInt);
            }
        }

        return Ints.toArray(intersection);
    }
}
