package com.lolo.se.hi;

import java.util.Hashtable;

public class FactorialCacheChecker {
    Hashtable<Integer, Integer> cache = new Hashtable<>();
    int getCachedFactorial(int number) {
        return cache.getOrDefault(number, 0);
    }

    void addFactorialToCache(int number, int factorial) {
        cache.put(number, factorial);
    }

}
