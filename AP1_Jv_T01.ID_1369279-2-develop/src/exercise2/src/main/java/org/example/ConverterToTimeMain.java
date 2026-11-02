package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ConverterToTimeMain {
    public static void main(String[] args) {
        int[] res = new int[3];
        int[] result = new int[3];

        Scanner scanner = new Scanner(System.in);
        int second = getNumber(scanner);
        res = convertTime(second);
        outputResult(second, res);
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


    public static int[] convertTime(int sec) {
        int[] result = new int[3];
        int hours = sec / 3600;
        int min = (sec % 3600) / 60;
        int seconds = sec % 60;
        result[0] = hours;
        result[1] = min;
        result[2] = seconds;
        return result;
    }

    private static boolean isCorrect(int seconds) {
        return (seconds >= 0);
    }

    public static void outputResult(int sec, int res[]) {
        if (isCorrect(sec)) {
            System.out.printf("%02d:%02d:%02d\n", res[0], res[1], res[2]);
        } else {
            System.out.println("Incorrect time");
        }
    }


}