package ru.ifmo.collections;

import java.util.TreeSet;
import java.util.Set;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    //multiset
    private Set<Integer> numbers = new TreeSet<>((first, second) -> {
        int compareResult = Integer.compare(second, first);
        if (compareResult == 0) {
            return -1;
        } else {
            return compareResult;
        }
    });

    private int k;

    public KthLargest(int k, int[] numbers) {
        this.k = k;
        for (int number : numbers) {
            this.numbers.add(number);
        }
    }

    public int add(int val) {
        numbers.add(val);
        if (numbers.size() < k) {
            return -1;
        }
        return (int) numbers.toArray()[k - 1];
    }
}

