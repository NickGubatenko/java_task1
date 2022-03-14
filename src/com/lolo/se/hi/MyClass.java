package com.lolo.se.hi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Integer:");
        int number = 0;
        try {
            number = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        int factorial = 1;
        if (number > 0) {
            for (int i = 2; i <= number; i++) {
                factorial = factorial * i;
            }
        }
        System.out.println(factorial);
    }

}
