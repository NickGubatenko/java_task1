package com.lolo.se.hi;

import java.io.IOException;

public class Calculator {
    private final CalculatorViewConsole ui;
    private final CalculatorPresenter te;

    public Calculator(CalculatorViewConsole ui, CalculatorPresenter te) {
        this.ui = ui;
        this.te = te;
    }

    public void run() throws IOException {
        ui.showLicenseAgreement();
        if (ui.isLicenseAccepted()) {
            te.handleTasks();
        } else {
            ui.showTerminationMessage();
        }
    }
}
