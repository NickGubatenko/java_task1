package com.lolo.se.hi;

import java.util.Hashtable;

public class CachedDataImpl<VALUE> implements CachedData<VALUE> {
    Hashtable<Integer, VALUE> cache = new Hashtable<>();

    @Override
    public VALUE getCached(int number) {
        return cache.get(number);
    }

    @Override
    public void addToCache(int number, VALUE result) {
        cache.put(number, result);
    }

    @Override
    public boolean isCached(int number) {
        return cache.containsKey(number);
    }
}
