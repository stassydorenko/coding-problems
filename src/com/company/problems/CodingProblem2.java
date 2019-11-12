package com.company.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CodingProblem2 {


    private CodingProblem2() {
    }

    /**[Hard]
     * Given an array of integers, find the first missing positive integer in linear time and constant space. In
     * other words, find the lowest positive integer that does not exist in the array. The array can contain
     * duplicates and negative numbers as well.
     * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
     *
     * This is just an example of how much easier it would be if it wasn't for this linear time constraint
     */
    public static int findLowestPositiveNotLinearTime(int[] arr) {
        arr = Arrays.stream(arr)
              .filter(i -> i > 0)
              .sorted()
              .distinct()
              .toArray();

        //if something is missing in the sorted array - it's our result
        for(int i = 1; i <= arr.length; i++) {
            if(arr[i-1] != i) {
                return i;
            }
        }
        //in case there are no missing integers - increment the biggest one
        return arr[arr.length-1] + 1;
    }


    /**
     * Linear time, but linear space as well - so just as an additional example
     */
    public static int findLowestPositiveLinearSpace(int[] arr) {
        int[] sortedInts = new int[arr.length+1];

        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];

            //we don't need anything less than zero
            //if anything is greater than the array size - it means there is definitely an integer that is missing,
            //otherwise all the numbers wouldn't fit into the array
            if(num > 0 && num <= arr.length) {
                sortedInts[num] = num;
            }
        }

        //if something's missing - return it
        for(int i = 1; i < sortedInts.length; i++) {
            if(sortedInts[i] != i) {
                return i;
            }
        }

        return sortedInts[sortedInts.length - 1] + 1;
    }


    /**
     * Another wrong implementation, linear space again
     */
    public static int findLowestPositiveLinearSpaceWithSet(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if(num > 0 && num <= arr.length) {
                set.add(num);
            }
        }

        //if we don't have it - it's our result
        for(int i = 1; i <= set.size(); i++) {
            if(!set.contains(i)) {
                return i;
            }
        }

        return set.size()+1;
    }

}
