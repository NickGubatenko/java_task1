package com.lolo.se.hi;

import java.io.IOException;

public class Calculator {
    private final UserInterface ui;
    private final TaskExecution te;

    public Calculator(UserInterface ui, TaskExecution te) {
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
