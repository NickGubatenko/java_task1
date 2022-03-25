package com.lolo.se.hi;

public interface CachedData<VALUE> {
    VALUE getCached(int number);
    void addToCache(int number, VALUE result);
    boolean isCached(int number);
}