package org.example;

import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FibonacciMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = getNumber(scanner);
        if (isCorrect(num)) {
            int result = countNumberFibonacci(num);
            outputNumberFibonacci(result);
        } else {
            System.out.println("Too large n");
        }

    }

    public static int getNumber(Scanner scanner) {
        while (true) {
            try {
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }

    public static int countNumberFibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        return countNumberFibonacci(num - 1) + countNumberFibonacci(num - 2);
    }

    public static boolean isCorrect(int num) {
        return (num <= 45);
    }

    public static void outputNumberFibonacci(int num) {
        System.out.println(num);
    }

}


