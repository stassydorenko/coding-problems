package com.company;

public class CodingProblem1 {

    /**
     * [Hard]
     * Given an array of integers, return a new array such that each element at index i of the new array is the
     * product of multiplying of all the numbers in the original array except the one at i.
     *
     * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our
     * input was [3, 2, 1], the expected output would be [2, 3, 6].
     *
     * Follow-up: what if you can't use division?
     */
    public static long[] multiplyExceptCurrentIndex(int[] input) {

        long[] result = new long[input.length];

        for(int i = 0; i < input.length; i++) {
            result[i] = multiplyAllExceptIndexPosition(input, i);
        }

        return result;
    }

    private static long multiplyAllExceptIndexPosition(int[] input, int position) {
        long result = 1;

        for(int i = 0; i < input.length; i++) {
            if(i == position) {
                continue;
            }
            result *= input[i];
        }

        return result;
    }



}
