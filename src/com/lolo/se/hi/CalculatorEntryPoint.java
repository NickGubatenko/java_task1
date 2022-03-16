package com.lolo.se.hi;
import java.io.*;

public class CalculatorEntryPoint {
    public static final CalculatorViewConsole ui = new CalculatorViewConsole();
    public static final CalculatorPresenter te = new CalculatorPresenter(ui);
    public static final Calculator calc = new Calculator(ui, te);

    public static void main(String[] args) throws IOException {
        calc.run();
    }
}
