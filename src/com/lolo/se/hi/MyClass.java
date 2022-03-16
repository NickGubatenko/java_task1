package com.lolo.se.hi;
import java.io.*;
import java.lang.Math;

public class MyClass {
    public static final UserInterface ui = new UserInterface();

    static void handleTasks() throws IOException {
        int task = ui.taskSelector();
        if (task == 1) {
            calcFactorial(ui.getNumber());
        } else if (task == 2) {
            calcSquareRoot(ui.getNumber());
        } else {
            ui.showWrongSelectorMessage();
        }
    }

    static void calcFactorial(int number) {
        int factorial = 1;
        if (number > 0) {
            for (int i = 2; i <= number; i++) {
                factorial = factorial * i;
            }
        }
        ui.showResult(factorial);
    }

    static void calcSquareRoot(int number) {
        double sq_root = Math.sqrt(number);
        ui.showResult(sq_root);
    }

    public static void main(String[] args) throws IOException {
        ui.showLicenseAgreement();
        if (ui.isLicenseAccepted()) {
            handleTasks();
        } else {
            ui.showTerminationMessage();

        }
    }
}
