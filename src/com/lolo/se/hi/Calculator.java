package com.lolo.se.hi;

public class Calculator {
    private final CalculatorView ui;
    private final CalculatorPresenter te;

    public Calculator(CalculatorView ui, CalculatorPresenter te) {
        this.ui = ui;
        this.te = te;
    }

    public void run() {
        ui.showLicenseAgreement();
        if (ui.isLicenseAccepted()) {
                te.handleTasks();
        } else {
            ui.showTerminationMessage();
        }
    }
}
