package org.example;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        List<User> users = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean incorrectAge = false;

        Result result;
        while (true) {
            result = getFirstLine(scanner);
            if (result.getIsCorrect() && (result.getUserCounter() > 0)) {
                break;
            } else if (result.getUserCounter() <= 0 && result.getIsCorrect()) break;
            else {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
        if (result.getUserCounter() > 0) {
            for (int i = 0; i < result.getUserCounter(); ) {
                String name = getUserName(scanner);
                int age = getUserAge(scanner);
                if (age > 0) {
                    users.add(new User(name, age));
                    i++;
                } else {
                    incorrectAge = true;

                }

            }
            if (incorrectAge) {
                System.out.println("Incorrect input. Age <= 0");
            }

            for (int i = 0; i < users.size(); i++) {
                if (i == (users.size() - 1) && users.get(i).getAge() > 0 && users.get(i).getAge() >= 18) {
                    System.out.println(users.get(i).getName());
                } else if (users.get(i).getAge() > 0 && i < (users.size() - 1) && users.get(i).getAge() >= 18) {
                    System.out.print(users.get(i).getName() + ", ");
                }
            }
        }
    }

    private static String getUserName(Scanner scanner) {
        return scanner.next();
    }

    private static Result getFirstLine(Scanner scanner) {
        int usersCounter = 0;
        Result result = new Result();
        result.setCorrect(true);
        if (scanner.hasNextInt()) {
            usersCounter = scanner.nextInt();
            result.setUserCounter(usersCounter);
        } else {
            result.setUserCounter(-1);
            result.setCorrect(false);
            scanner.next();
        }
        return result;
    }

    private static int getUserAge(Scanner scanner) {

        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
    }


}

class Result {
    private boolean isCorrect;
    private int userCounter;

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public void setUserCounter(int userCounter) {
        this.userCounter = userCounter;
    }

    public int getUserCounter() {
        return userCounter;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

}
