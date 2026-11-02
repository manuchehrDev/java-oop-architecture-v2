package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SameNumbersMain {

    private static int[] array;
    private static int[] arrayResult;
    private static int counterResult = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = getNumber(scanner);
        if (isCorrectSize(number)) {
            setValuesArray(number, scanner);
            handlerNumbers(number);
            outputResult();
        }
    }


    public static boolean isCorrectSize(int sizeArray) {
        boolean isCorrect = true;
        if (sizeArray <= 0) {
            System.out.println("Input error. Size <= 0");
            isCorrect = false;
        } else {
            array = new int[sizeArray];
        }
        return isCorrect;
    }

    public static void setValuesArray(int sizeArray, Scanner scanner) {
        for (int i = 0; i < sizeArray; i++) {
            array[i] = getValues(scanner);
        }
    }

    public static void handlerNumbers(int size) {
        for (int i = 0; i < size; i++) {
            countNumbers(array[i]);
        }
        arrayResult = new int[counterResult];
        int tempSizeRes = 0;
        for (int i = 0; i < size; i++) {
            if (calculate(array[i])) {
                arrayResult[tempSizeRes++] = array[i];
            }
        }
    }

    public static boolean calculate(int num) {
        int temp = num;
        temp = Math.abs(temp);
        int last = num % 10;
        int first = 0;
        boolean isSame = true;
        if (temp > 9) {
            while (temp != 0) {
                int n = temp % 10;
                first = n;
                temp = temp / 10;
            }
            if (first != last) {
                isSame = false;
            }
        }
        return isSame;
    }

    private static boolean countNumbers(int num) {
        int temp = num;
        int last = num % 10;
        int first = 0;
        boolean isSame = true;


        while (temp != 0) {
            int n = temp % 10;
            first = n;
            temp = temp / 10;
        }
        if (first == last) {
            counterResult++;
        } else {
            isSame = false;
        }
        return isSame;
    }

    public static void outputResult() {
        if (counterResult != 0) {
            for (int i = 0; i < counterResult; i++) {
                if (i == counterResult - 1) {
                    System.out.println(arrayResult[i]);
                } else {
                    System.out.print(arrayResult[i] + " ");
                }
            }
        } else {
            System.out.println("There are no such elements");
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
