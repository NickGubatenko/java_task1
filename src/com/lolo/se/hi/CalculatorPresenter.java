package com.lolo.se.hi;

import java.lang.Math;

public class CalculatorPresenter {
    private final CalculatorView ui;
    private final FactorialCacheChecker factorialCacheChecker = new FactorialCacheChecker();

    public CalculatorPresenter(CalculatorView ui) {
        this.ui = ui;
    }

    void handleTasks() {
        CalculatorView.TaskType task = ui.taskSelector();

        switch (task) {
            case CALCULATE_FACTORIAL   -> calcFactorial(ui.getNumber());
            case CALCULATE_SQUARE_ROOT -> calcSquareRoot(ui.getNumber());
            default                    -> ui.showWrongSelectorMessage();
        }
    }

    /***
     * @param number - целое число для которого вычисляем факториал
     */
    private void calcFactorial(int number) {
        int factorial = 1;
        int CACHED_FACTORIAL_NOT_FOUND_CODE = 0;
        int factorialCacheResult = factorialCacheChecker.getCachedFactorial(number);
        if (factorialCacheResult == CACHED_FACTORIAL_NOT_FOUND_CODE) {
            if (number > 0) {
                for (int i = 2; i <= number; i++) {
                    factorial = factorial * i;
                }
            }
            factorialCacheChecker.addFactorialToCache(number, factorial);
        } else {
            factorial = factorialCacheResult;
        }
        ui.showResult(factorial);
    }

    private void calcSquareRoot(int number) {
        double sq_root = Math.sqrt(number);
        ui.showResult(sq_root);
    }

}
