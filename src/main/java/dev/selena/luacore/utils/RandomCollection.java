package dev.selena.luacore.utils;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

/**
 * Used for weighted random item/object generation
 * @param <E>
 */
public class RandomCollection<E> {
    private final NavigableMap<Double, E> map = new TreeMap<Double, E>();
    private final Random random;
    private double total = 0;

    public RandomCollection() {
        this(new Random());
    }

    public RandomCollection(Random random) {
        this.random = random;
    }

    /**
     * Used for adding a weight
     * @param weight The weight of the item added to the map
     * @param result The item itself
     * @return This instance for further usage
     */
    public RandomCollection<E> add(double weight, E result) {
        if (weight <= 0) return this;
        total += weight;
        map.put(total, result);
        return this;
    }

    /**
     * Gets a weighted random value
     * @return The random value from the map
     */
    public E getRandom() {
        double value = random.nextDouble() * total;
        return map.higherEntry(value).getValue();
    }
}