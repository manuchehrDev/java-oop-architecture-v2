package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SortedSubSequenceMain {

    static int prevNumber = 0;
    static int currentNumber = 0;
    static int index = 0;
    static boolean isFirstLine = false;
    static boolean isSorted = true;
    static boolean isInteger = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sortSequence(scanner);
    }


    public static void getNumbers(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                currentNumber = scanner.nextInt();
                if (currentNumber > prevNumber) {
                    prevNumber = currentNumber;
                } else {
                    isSorted = false;
                    break;
                }
                index++;
            } else {
                isInteger = false;
                return;
            }

        }
    }


    public static boolean firstLineHandler(Scanner scanner, int num) {
        boolean isCorrect = true;
        if (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            } else {
                isCorrect = false;
            }
        } else {
            isCorrect = false;
        }
        return isCorrect;
    }

    public static void sortSequence(Scanner scanner) {
        int number = 0;
        isFirstLine = firstLineHandler(scanner, number);
        if (isFirstLine) {
            getNumbers(scanner);
            if (!isSorted) {
                System.out.println("The sequence is not ordered from the ordinal number of the number " + (index + 1));
            } else if (isSorted && !isInteger) {
                System.out.println("The sequence is ordered in ascending order");
            }
        } else {
            System.out.println("Input error");
        }

    }

}