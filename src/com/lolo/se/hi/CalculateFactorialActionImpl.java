package com.lolo.se.hi;

public class CalculateFactorialActionImpl implements CalculateFactorialAction {
    private final CachedData<Integer> factorialCacheChecker = new CachedDataImpl();


    @Override
    public int execute(int number) {
        int factorial = 1;
        factorialCacheChecker.initCache();
        if (factorialCacheChecker.isCached(number)) {
            factorial = factorialCacheChecker.getCached(number);
        } else {
            if (number > 0) {
                for (int i = 2; i <= number; i++) {
                    factorial = factorial * i;
                }
            }
            factorialCacheChecker.addToCache(number, factorial);
        }
        return factorial;
    }
}
