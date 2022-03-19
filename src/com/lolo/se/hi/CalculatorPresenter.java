package com.lolo.se.hi;

import java.lang.Math;

public class CalculatorPresenter {
    private final CalculatorView ui;

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
        if (number > 0) {
            for (int i = 2; i <= number; i++) {
                factorial = factorial * i;
            }
        }
        ui.showResult(factorial);
    }

    private void calcSquareRoot(int number) {
        double sq_root = Math.sqrt(number);
        ui.showResult(sq_root);
    }

}
