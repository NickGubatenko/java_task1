package com.lolo.se.hi;

public class CalculatorViewAlternativeConsole implements CalculatorView {

    @Override
    public void showTerminationMessage() {

    }

    @Override
    public void showWrongSelectorMessage() {

    }

    @Override
    public TaskType taskSelector() {
        return TaskType.CALCULATE_FACTORIAL;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public void showResult(double result) {
        System.out.println("result" + result);
    }

    @Override
    public boolean isLicenseAccepted() {
        return true;
    }

    @Override
    public void showLicenseAgreement() {

    }
}
