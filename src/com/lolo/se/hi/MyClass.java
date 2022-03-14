package com.lolo.se.hi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class MyClass {
    public static void main(String[] args) throws IOException {

        String lang = System.getProperty("user.language");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
    }
}
