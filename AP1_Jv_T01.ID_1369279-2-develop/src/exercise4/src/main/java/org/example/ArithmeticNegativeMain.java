package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ArithmeticNegativeMain {

    private static int[] array;
    private static int sizeArray = 0;
    private static int counterNegativeNumber = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = getNumber(scanner);
        boolean isCorrectSize = sizeHandler(size);
        if (isCorrectSize) {
            setValuesArray(size, scanner);
            outputResult();
        }

    }


    private static boolean isCorrectSize(int size) {
        return size > 0;
    }

    public static boolean sizeHandler(int size) {
        boolean flag = true;
        if (isCorrectSize(size)) {
            array = new int[size];
            sizeArray = size;
        } else {
            System.out.println("Input error. Size <= 0");
            flag = false;
        }
        return flag;
    }

    public static boolean setValuesArray(int sizeArray, Scanner scanner) {
        boolean flag = true;
        if (sizeHandler(sizeArray)) {
            for (int i = 0; i < sizeArray; i++) {
                int num = getValues(scanner);
                array[i] = num;
                if (num < 0) {
                    counterNegativeNumber++;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    public static double calculateArithmeticNegative() {
        int result = 0;
        if (sizeArray > 0) {
            for (int i = 0; i < sizeArray; i++) {
                if (array[i] < 0) {
                    result += array[i];
                }
            }
        }
        return (double) result / counterNegativeNumber;
    }

    public static void outputResult() {
        if (canCalculate()) {
            System.out.println((int) calculateArithmeticNegative());
        } else {
            System.out.println("There are no negative elements");
        }
    }


    public static boolean canCalculate() {
        return counterNegativeNumber != 0;
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

    private static int getValues(Scanner scanner) {
        while (true) {
            try {
                if (scanner.hasNextInt()) {
                    return scanner.nextInt();
                } else {
                    System.out.println("Could not parse a number. Please, try again");
                    scanner.next();
                }
            } catch (NumberFormatException e) {

            }
        }
    }


}