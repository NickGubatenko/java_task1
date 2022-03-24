package com.lolo.se.hi;

public class CalculatorPresenter {
    private final CalculatorView ui;
    private final CalculateFactorialAction factorialCalc = new CalculateFactorialActionImpl();
    private final CalculateSquareRootAction squareRootCalc = new CalculateSquareRootImpl();
    public CalculatorPresenter(CalculatorView ui) {
        this.ui = ui;
    }

    void handleTasks() {
        switch (ui.taskSelector()) {
            case CALCULATE_FACTORIAL   -> ui.showResult(factorialCalc.execute(ui.getNumber()));
            case CALCULATE_SQUARE_ROOT -> ui.showResult(squareRootCalc.execute(ui.getNumber()));
            default                    -> ui.showWrongSelectorMessage();
        }
    }
}
