package com.lolo.se.hi;

public class CalculateSquareRootImpl implements CalculateSquareRootAction {
    private final CachedData<Double> squareRootCache = new CachedDataImpl();
    @Override
    public double execute(int number) {
        if (squareRootCache.isCached(number)){
            return squareRootCache.getCached(number);
        } else {
            double squareRoot = Math.sqrt(number);
            squareRootCache.addToCache(number, squareRoot);
            return squareRoot;
        }
    }
}
