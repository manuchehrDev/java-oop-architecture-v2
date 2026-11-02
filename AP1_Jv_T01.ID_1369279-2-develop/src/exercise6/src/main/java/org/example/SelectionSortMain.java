package org.example;

import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SelectionSortMain {

    private static double[] srcArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        int sizeArray = getNumber(scanner);

        if (setSize(sizeArray)) {
            setSrcArray(scanner, sizeArray);
            selectionSort();
            outputResult();
        } else {
            System.out.println("Input error. Size <= 0");
        }
    }


    public static boolean setSize(int sizeArray) {
        if (sizeArray > 0) {
            srcArray = new double[sizeArray];
        }
        return (sizeArray > 0);
    }

    public static void setSrcArray(Scanner scanner, int size) {
        for (int i = 0; i < size; i++) {
            srcArray[i] = getDouble(scanner);
        }
    }

    public static void selectionSort() {
        for (int i = 0; i < srcArray.length; i++) {
            int index = i;
            for (int j = i + 1; j < srcArray.length; j++) {
                if (srcArray[j] < srcArray[index]) {
                    index = j;
                }
            }

            double temp = srcArray[index];
            srcArray[index] = srcArray[i];
            srcArray[i] = temp;
        }
    }

    public static void outputResult() {
        for (int i = 0; i < srcArray.length; i++) {
            if (i == srcArray.length - 1) {
                System.out.println(srcArray[i]);
            } else {
                System.out.print(srcArray[i] + " ");
            }
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

    public static double getNumberDouble(Scanner scanner) {
        while (true) {
            try {
                String line = scanner.nextLine().trim();
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }


    private static double getDouble(Scanner scanner) {
        while (true) {
            try {
                if (scanner.hasNextDouble()) {
                    return scanner.nextDouble();
                } else {
                    System.out.println("Could not parse a number. Please, try again");
                    scanner.next();
                }
            } catch (NumberFormatException e) {

            }
        }
    }


}