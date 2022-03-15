package com.lolo.se.hi;

import java.io.IOException;

public class MyClass {

    private static final TerminalView view = new TerminalView();

    static void handleTasks() throws IOException {
        int task = view.taskSelector();
        if (task == 1) {
            calcFactorial(view.getNumber());
        } else if (task == 2) {
            calcSquareRoot(view.getNumber());
        } else {
            view.showInvalidSelectorError();
        }
    }

    static void calcFactorial(int number) {
        int factorial = 1;
        if (number > 0) {
            for (int i = 2; i <= number; i++) {
                factorial = factorial * i;
            }
        }
        view.showFactorialCalcResult(factorial);
    }


    static void calcSquareRoot(int number) {
        double sq_root = Math.sqrt(number);
        view.showSquareRootCalcResult(number, sq_root);
    }

    public static void main(String[] args) throws IOException {
        view.showLicenseAgreement();
        if (view.isLicenseAccepted()) {
            handleTasks();
        } else {
            view.showTerminationMessage();
        }
    }
}
