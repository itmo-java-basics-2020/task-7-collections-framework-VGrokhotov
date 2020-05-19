package ru.ifmo.collections;



import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private Set<Integer> numbers = new LinkedHashSet<>();
    private Set<Integer> wasInNumbers = new HashSet<>();

    public FirstUnique(int[] numbers) {
        for (int number : numbers) {
            this.add(number);
        }
    }


    public int showFirstUnique() {
        var iterator = numbers.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return -1;
    }

    public void add(int value) {
        if (numbers.contains(value)) {
            numbers.remove(value);
            return;
        }

        if (!wasInNumbers.contains(value)) {
            numbers.add(value);
            wasInNumbers.add(value);
        }
    }
}
