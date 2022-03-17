package com.lolo.se.hi;

import java.io.*;

public class CalculatorViewConsole {
    private static final int UNKNOWN_CODE = Integer.MIN_VALUE;
    private static final int CALCULATE_FACTORIAL_CODE = 1;
    private static final int CALCULATE_SQUARE_ROOT_CODE = 2;

    public enum TaskType {

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

    void showTerminationMessage() {
        System.out.println("License is not accepted. Program will be terminated");
    }

    void showWrongSelectorMessage() {
        System.err.println("Invalid selector!");
    }

    boolean isRussianLanguage() {
        String lang = System.getProperty("user.language");
        return lang.equals("ru");
    }

    TaskType taskSelector() throws IOException {
        if (isRussianLanguage()) {
            System.out.print("Введите задачу (1 - факториал, 2 - квадратный корень):");
        } else {
            System.out.print("Enter task (1 - factorial, 2 - square root):");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int code = Integer.parseInt(br.readLine());
        return TaskType.valueOfCode(code);

        //return Integer.parseInt(br.readLine());
    }

    int getNumber() throws IOException {
        if (isRussianLanguage()) {
            System.out.print("Введите целое число:");
        } else {
            System.out.print("Enter Integer:");
        }
        int number = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            number = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        return number;
    }

    void showResult(double result) {
        System.out.println("result = " + result);
    }

    boolean isLicenseAccepted() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String licenseAccepted = br.readLine();
        return licenseAccepted.equals("y");
    }

    void showLicenseAgreement() throws IOException {
        File resourceFile = new File("src/com/lolo/se/hi/license");
        String path = resourceFile.getPath();
        String everything;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        }
        System.out.print(everything);
    }
}