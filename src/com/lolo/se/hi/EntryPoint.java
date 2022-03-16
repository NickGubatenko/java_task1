package com.lolo.se.hi;
import java.io.*;

public class EntryPoint {
    public static final UserInterface ui = new UserInterface();
    public static final TaskExecution te = new TaskExecution(ui);
    public static final Calculator calc = new Calculator(ui, te);

    public static void main(String[] args) throws IOException {
        calc.run();
    }
}
