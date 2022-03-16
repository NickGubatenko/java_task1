package com.lolo.se.hi;
import java.io.*;

public class MyClass {
    public static final UserInterface ui = new UserInterface();
    public static final TaskExecution te = new TaskExecution(ui);

    public static void main(String[] args) throws IOException {
        ui.showLicenseAgreement();
        if (ui.isLicenseAccepted()) {
            te.handleTasks();
        } else {
            ui.showTerminationMessage();

        }
    }
}
