package ru.ifmo.collections;

import java.util.Collections;
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

    private Set<Node> numbers = new TreeSet<>(Collections.reverseOrder());
    private int k;

    public KthLargest(int k, int[] numbers) {
        this.k = k;
        for (int number : numbers) {
            this.numbers.add(new Node(number));
        }
    }

    public int add(int val) {
        numbers.add(new Node(val));
        if (numbers.size() < k) {
            return -1;
        }
        return ((Node) numbers.toArray()[k - 1]).getValue();
    }

    private static class Node implements Comparable<Node> {

        private int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(Node o) {
            int compareResult = Integer.compare(value, o.value);
            if (compareResult == 0) {
                return -1;
            } else {
                return compareResult;
            }
        }
    }
}

