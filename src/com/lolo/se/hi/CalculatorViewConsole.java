package com.lolo.se.hi;

import java.io.*;

public class CalculatorViewConsole implements CalculatorView {

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String licenseAccepted = br.readLine();
            return licenseAccepted.equals("y");
        } catch (IOException exception) {
            licenseReadErrorMessage();
            return false;
        }
    }

    public boolean isContinueTask() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Continue? y/n");
        try {
            String continueTask = br.readLine();
            return continueTask.equals("y");
        } catch (IOException exception) {
            licenseReadErrorMessage();
            return false;
        }
    }


    private void licenseReadErrorMessage() {
        System.out.println("License agreement can't be shown. The program will be closed");
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
            licenseReadErrorMessage();
        }
    }
}