package com.lolo.se.hi;

public class CalculatorEntryPoint {
    public static final CalculatorViewConsole ui = new CalculatorViewConsole();
    public static final CalculatorViewAlternativeConsole uiAlternative = new CalculatorViewAlternativeConsole();
    public static final CalculatorPresenter ca = new CalculatorPresenter(ui);
    public static final Calculator calc = new Calculator(ui, ca);

    public static void main(String[] args) {
        calc.run();
    }
}
