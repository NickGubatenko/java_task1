package com.lolo.se.hi;

import java.io.*;

public class CalculatorViewConsole {
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

    int taskSelector() throws IOException {
        if (isRussianLanguage()) {
            System.out.print("Введите задачу (1 - факториал, 2 - квадратный корень):");
        } else {
            System.out.print("Enter task (1 - factorial, 2 - square root):");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
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