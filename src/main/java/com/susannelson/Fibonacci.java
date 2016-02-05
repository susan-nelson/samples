package com.susannelson;

public class Fibonacci {

    //int[] sequence = {1,1,2,3,5,8,13};

    public int fibRecursive(int index) {

        if (index < 1) {
            return 0;
        }

        if (index == 1) {
            return 1;
        }

        return fibRecursive(index - 2) + fibRecursive(index - 1);
    }
}
