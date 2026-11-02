package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FilterStringMain {

    static boolean isCorrectSize = true;
    static int sizeArray = 0;
    static String filterString;

    static List<String> stringsList;
    static List<String> resultList;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        FilterString filterString = new FilterString();
        handleStringList(scanner);
    }


    public static boolean firstLineHandler(Scanner scanner) {
        boolean isCorrect = true;
        if (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                sizeArray = scanner.nextInt();
            } else {
                isCorrect = false;
            }
        } else {
            isCorrect = false;
        }
        return isCorrect;
    }


    public static void getString(Scanner scanner) {
        for (int i = 0; i <= sizeArray; i++) {
            stringsList.add(scanner.nextLine());
        }
    }

    public static void getFilterString(Scanner scanner) {
        if (scanner.hasNext()) {
            filterString = scanner.nextLine();
        }
    }

    public static void simpleSearch() {
        for (int i = 0; i < stringsList.size(); i++) {
            String str = stringsList.get(i);
            if (searchFilter(str, filterString)) {
                resultList.add(str);
            }
        }
    }

    private static boolean searchFilter(String string, String filter) {
        boolean find = true;

        if (string.length() < filter.length()) {
            find = false;
        }

        for (int i = 0; i < (string.length() - filter.length()); i++) {
            boolean findFilter = true;
            for (int j = 0; j < filter.length(); j++) {
                if (string.charAt(i + j) != filter.charAt(j)) {
                    findFilter = false;
                    break;
                }
            }
            if (findFilter) {
                find = true;
            } else {
                find = false;
            }
        }
        return find;
    }


    public static void handleStringList(Scanner scanner) {
        stringsList = new LinkedList<>();
        resultList = new LinkedList<>();
        while (true) {
            boolean isCor = firstLineHandler(scanner);
            if (!isCor) {
                System.out.println("Could not parse a number. Please try again and retry the input.");
                scanner.next();
            } else {
                if (isCor && sizeArray > 0) {
                    getString(scanner);
                    getFilterString(scanner);
                    simpleSearch();
                    outputResult();
                    break;
                } else if (sizeArray <= 0 && isCor) {
//            System.out.println("Input error. Size <= 0");
//                scanner.next();
                    break;
                }
            }
        }
    }

    public static void outputResult() {
        if (!resultList.isEmpty()) {
            resultList.stream().forEach(e -> {
                System.out.println(e);
            });
        }

    }
}