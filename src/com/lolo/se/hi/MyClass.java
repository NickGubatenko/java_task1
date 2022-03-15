package com.lolo.se.hi;
import java.io.*;
import java.lang.Math;

public class MyClass {

    static void showTerminationMessage() {
        System.out.println("License is not accepted. Program will be terminated");
    }

    static boolean isRussianLanguage() {
        String lang = System.getProperty("user.language");
        return lang.equals("ru");
    }

    static int taskSelector() throws IOException {
        if (isRussianLanguage()) {
            System.out.print("Введите задачу (1 - факториал, 2 - квадратный корень):");
        } else {
            System.out.print("Enter task (1 - factorial, 2 - square root):");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    static int getNumber() throws IOException {
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

    static void handleTasks() throws IOException {
        int task = taskSelector();
        if (task == 1) {
            calcFactorial(getNumber());
        } else if (task == 2) {
            calcSquareRoot(getNumber());
        } else {
            System.err.println("Invalid selector!");
        }
    }

    static boolean isLicenseAccepted() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String licenseAccepted = br.readLine();
        return licenseAccepted.equals("y");
    }

    static void showLicenseAgreement() throws IOException {
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

    static void calcFactorial(int number) {
        int factorial = 1;
        if (number > 0) {
            for (int i = 2; i <= number; i++) {
                factorial = factorial * i;
            }
        }
        System.out.println("factorial = " + factorial);
    }


    static void calcSquareRoot(int number) {
        double sq_root = Math.sqrt(number);
        System.out.println("square root of " + number + ": " + sq_root);
    }


    public static void main(String[] args) throws IOException {
        showLicenseAgreement();
        if (isLicenseAccepted()) {
            handleTasks();
        } else {
            showTerminationMessage();
        }
    }
}
