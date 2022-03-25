package com.lolo.se.hi;

public interface CalculatorView {
    int UNKNOWN_CODE = Integer.MIN_VALUE;
    int CALCULATE_FACTORIAL_CODE = 1;
    int CALCULATE_SQUARE_ROOT_CODE = 2;

    enum TaskType {

        CALCULATE_FACTORIAL(CALCULATE_FACTORIAL_CODE),
        CALCULATE_SQUARE_ROOT(CALCULATE_SQUARE_ROOT_CODE),
        UNKNOWN(UNKNOWN_CODE);

        public final int code;

        TaskType(int code) {
            this.code = code;
        }

        public static TaskType valueOfCode(int code) {
            for (TaskType type : values()) {
                if (type.code == code) {
                    return type;
                }
            }
            return TaskType.UNKNOWN;
        }

    }

    void showTerminationMessage();
    void showWrongSelectorMessage();
    TaskType taskSelector();
    int getNumber();
    void showResult(double result);
    boolean isLicenseAccepted();
    void showLicenseAgreement();
    boolean isContinueTask();
}
