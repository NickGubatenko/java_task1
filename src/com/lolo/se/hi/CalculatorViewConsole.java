package com.lolo.se.hi;

import java.io.*;
import java.util.Locale;

public class CalculatorViewConsole implements CalculatorView {
    private final String LICENSE_ERROR_MESSAGE = "License agreement can't be shown. The program will be closed";
    private final String USER_INPUT_ERROR_MESSAGE = "User input error. The program will be closed";

    public void showTerminationMessage() {
        System.out.println("License is not accepted. Program will be terminated");
    }

    public void showWrongSelectorMessage() {
        System.err.println("Invalid selector!");
    }

    private boolean isRussianLanguage() {
        String lang = System.getProperty("user.language");
        return lang.equals("ru");
    }

    private void ShowErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void ShowContinueTaskMessage() {
        System.out.println("Continue task execution? Y/N");
    }

    private boolean isInputYesORNo(String errorMessage) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine().toLowerCase(Locale.ROOT);
            return input.equals("y");
        } catch (IOException exception) {
            ShowErrorMessage(errorMessage);
            return false;
        }
    }

    public CalculatorView.TaskType taskSelector() {
        if (isRussianLanguage()) {
            System.out.print("Введите задачу (1 - факториал, 2 - квадратный корень):");
        } else {
            System.out.print("Enter task (1 - factorial, 2 - square root):");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int code = Integer.parseInt(br.readLine());
            return CalculatorView.TaskType.valueOfCode(code);
        } catch (IOException exception) {
            System.out.print("task selector IO error");
            return CalculatorView.TaskType.UNKNOWN;
        }
    }

    public int getNumber() {
        if (isRussianLanguage()) {
            System.out.print("Введите целое число:");
        } else {
            System.out.print("Enter Integer:");
        }
        int number = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            number = Integer.parseInt(br.readLine());
        } catch (IOException exception) {
            System.err.println("Invalid Format!");
        }
        return number;
    }

    public void showResult(double result) {
        System.out.println("result = " + result);
    }

    public boolean isLicenseAccepted() {
        return isInputYesORNo(LICENSE_ERROR_MESSAGE);
    }

    public boolean isContinueTask() {
        return isInputYesORNo(USER_INPUT_ERROR_MESSAGE);
    }

    public void showLicenseAgreement() {
        File resourceFile = new File("src/com/lolo/se/hi/license");
        String path = resourceFile.getPath();
        String everything;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
            System.out.print(everything);
        } catch (IOException exception) {
            ShowErrorMessage(LICENSE_ERROR_MESSAGE);
        }
    }
}