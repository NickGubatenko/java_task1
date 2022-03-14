package com.lolo.se.hi;
import java.io.*;
import java.lang.Math;

public class MyClass {
    public static void main(String[] args) throws IOException {
        // show license agreement
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

        // ask if license agreement accepted
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String license_accepted_yes_no = br.readLine();
        if (license_accepted_yes_no.equals("y")) {

            //get lang and print task selection message
            String lang = System.getProperty("user.language");
            if (lang.equals("ru")) {
                System.out.print("Введите задачу (1 - факториал, 2 - квадратный корень):");
            } else {
                System.out.print("Enter task (1 - factorial, 2 - square root):");
            }

            int task_selector = Integer.parseInt(br.readLine());
            if (lang.equals("ru")) {
                System.out.print("Введите целое число:");
            } else {
                System.out.print("Enter Integer:");
            }

            int number = 0;
            try {
                number = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid Format!");
            }

            if (task_selector == 1) { //factorial
                int factorial = 1;
                if (number > 0) {
                    for (int i = 2; i <= number; i++) {
                        factorial = factorial * i;
                    }
                }
                System.out.println("factorial = " + factorial);

            } else if (task_selector == 2) { //square root
                double sq_root = Math.sqrt(number);
                System.out.println("square root of " + number + ": " + sq_root);

            } else { //wrong selector
                System.err.println("Invalid selector!");
            }
        } else {
            System.out.println("License is not accepted. Program will be terminated");
        }



    }
}
