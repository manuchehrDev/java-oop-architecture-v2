package org.example;

import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FindMaxMinMain {

    private static int sizeArray = -1;
    private static double[] resArray;
    private static int counterDouble = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = getPath(scanner);
        outputFile("src/exercise7/src/main/resources/" + path);
    }




    public static String getPath(Scanner scanner) {
        return scanner.nextLine();
    }

    public static boolean isValidFile(String path) {
        File file = new File(path);
        return file.exists() && file.isFile();
    }

    public static void outputFile(String path) {
        if (isValidFile(path)) {
            readFile(path);
        } else {
            try (BufferedWriter bufferedWriter = new
                    BufferedWriter(new FileWriter("src/exercise7/src/main/resources/result.txt"))) {
                if (resArray == null) {
                    bufferedWriter.write("");
                    bufferedWriter.close();
                }
            } catch (IOException e) {

            }
            System.out.println("Input error. File doesn't exist");
        }
    }

    private static boolean getFirstLineFromFile(Scanner scanner) {
        boolean isValidValue = true;

        if (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            String[] temp = line.split(" ");
            sizeArray = (int) Double.parseDouble(temp[0]);
            if (sizeArray <= 0) {
                isValidValue = false;
            }
        }
        return isValidValue;
    }

    private static void readFile(String path) {
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            boolean isCorrectFirstLine = getFirstLineFromFile(scanner);
            boolean noError = processingReadFile(isCorrectFirstLine, scanner);
            if (noError && resArray != null) {
                printResult();
                selectionSort(resArray);
            }
            if (!noError) {
                resArray = null;
            }
            writeToFile(resArray);
        } catch (FileNotFoundException e) {
            scanner.close();
        }
        scanner.close();
    }

    private static void writeToFile(double[] resArray) {

        try (BufferedWriter bufferedWriter = new
                BufferedWriter(new FileWriter("src/exercise7/src/main/resources/result.txt"))) {
            if (resArray == null) {
                bufferedWriter.write("");
                bufferedWriter.close();
                return;
            }
            int lengthArray = resArray.length;
            if (lengthArray == 1) {
                bufferedWriter.write(String.valueOf(resArray[0]) + "\n");
            } else {
                bufferedWriter.write(String.valueOf(resArray[0]) + " ");
                bufferedWriter.write(String.valueOf(resArray[lengthArray - 1]) + "\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {
        }

    }

    private static int countDoubleElements(String line) {
        int count = 0;
        String[] str = line.split(" ");
        for (int i = 0; i < str.length; i++) {
            try {
                if (Double.isFinite(Double.parseDouble(str[i]))) {
                    count++;
                }
            } catch (NumberFormatException e) {

            }
        }
        return count;
    }

    private static boolean processingReadFile(boolean isCorrectFirstLine, Scanner scanner) {
        boolean noError = true;
        if (isCorrectFirstLine) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine().trim();
                counterDouble = countDoubleElements(line);
                int lineLength = line.split(" ").length;
                resArray = new double[counterDouble];
                if (sizeArray == (lineLength) || sizeArray == counterDouble) {
                    String[] lineElements = new String[lineLength];
                    lineElements = line.split(" ");
                    int nu = 0;
                    for (int i = 0; i < lineLength; i++) {
                        try {
                            if (Double.isFinite(Double.parseDouble(lineElements[i]))) {
                                double elements = Double.parseDouble(lineElements[i]);
                                resArray[nu++] = elements;
                            }
                        } catch (NumberFormatException e) {

                        }

                    }
                } else {
                    System.out.println("Input error. Insufficient number of elements");
                    noError = false;
                }
            }
        } else {
            System.out.println("Input error. Size <= 0");
            noError = false;
        }
        return noError;
    }

    public static void selectionSort(double[] srcArray) {
        int size = srcArray.length;
        for (int i = 0; i < size; i++) {
            int index = i;
            for (int j = i + 1; j < size; j++) {
                if (srcArray[j] < srcArray[index]) {
                    index = j;
                }
            }

            double temp = srcArray[index];
            srcArray[index] = srcArray[i];
            srcArray[i] = temp;
        }
    }

    public static void printResult() {
        System.out.println(sizeArray);
        for (int i = 0; i < resArray.length; i++) {
            if (i == resArray.length - 1) {
                System.out.println(resArray[i]);
            } else {
                System.out.print(resArray[i] + " ");
            }

        }
        System.out.println("Saving min and max values in file");
    }

}