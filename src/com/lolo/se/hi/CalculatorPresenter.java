package com.lolo.se.hi;

import java.io.IOException;
import java.lang.Math;
//import static com.lolo.se.hi.CalculatorViewConsole.CALCULATE_FACTORIAL;
//import static com.lolo.se.hi.CalculatorViewConsole.CALCULATE_SQUARE_ROOT;


public class CalculatorPresenter {
    private final CalculatorViewConsole ui;


    public CalculatorPresenter(CalculatorViewConsole ui) {
        this.ui = ui;
    }

    void handleTasks() throws IOException {
        CalculatorViewConsole.TaskType task = ui.taskSelector();

        switch (task) {
            case CALCULATE_FACTORIAL   -> calcFactorial(ui.getNumber());
            case CALCULATE_SQUARE_ROOT -> calcSquareRoot(ui.getNumber());
            default                    -> ui.showWrongSelectorMessage();
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
