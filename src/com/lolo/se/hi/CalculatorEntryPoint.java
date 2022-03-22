package com.lolo.se.hi;
import java.io.*;

public class CalculatorEntryPoint {
    public static final CalculatorViewConsole ui = new CalculatorViewConsole();
    public static final CalculatorViewAlternativeConsole uiAlternative = new CalculatorViewAlternativeConsole();
    public static final CalculatorPresenter te = new CalculatorPresenter(ui);
    public static final Calculator calc = new Calculator(uiAlternative, te);

    public static void main(String[] args) {
        calc.run();
    }
}
