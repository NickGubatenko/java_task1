package com.lolo.se.hi;

import java.io.IOException;
import java.lang.Math;

public class CalculatorPresenter {
    private final CalculatorViewConsole ui;

    public CalculatorPresenter(CalculatorViewConsole ui) {
        this.ui = ui;
    }

    void handleTasks() throws IOException {
        int task = ui.taskSelector();
        if (task == 1) {
            calcFactorial(ui.getNumber());
        } else if (task == 2) {
            calcSquareRoot(ui.getNumber());
        } else {
            ui.showWrongSelectorMessage();
        }
    }

    void calcFactorial(int number) {
        int factorial = 1;
        if (number > 0) {
            for (int i = 2; i <= number; i++) {
                factorial = factorial * i;
            }
        }
        ui.showResult(factorial);
    }

    void calcSquareRoot(int number) {
        double sq_root = Math.sqrt(number);
        ui.showResult(sq_root);
    }

}
