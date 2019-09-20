package org.zlasu.readConsole;

import java.util.Scanner;
//TODO fix problem with spaces in the read line

public class ReadSystemConsole {

    public static String readString(Scanner scanner, String question) {
        System.out.println(question);

        return scanner.next();
    }

    public static int readInt(Scanner scanner, String question) {
        System.out.println(question);

        while (!scanner.hasNextInt()) {
            System.out.println("To nie jest liczba.");
            System.out.println(question);
            scanner.nextLine();
        }
        return Integer.parseInt(scanner.next());
    }

    public static int readPositiveInt(Scanner scanner, String question) {
        int result = readInt(scanner, question);

        while (result < 0) {
            System.out.println("Podaj warosc wikesza od 0.");
            result = readInt(scanner, question);
        }
        return result;
    }

    public static double readDouble(Scanner scanner, String question) {
        System.out.println(question);

        while (!scanner.hasNextDouble()) {
            System.out.println("To nie jest poprawna liczba.");
            System.out.println(question);
            scanner.nextLine();
        }

        return Double.parseDouble(scanner.next());
    }

    public static double readPositiveDouble(Scanner scanner, String question) {
        double result = readDouble(scanner, question);

        while (result < 0) {
            System.out.println("Podaj warosc wikesza od 0.");
            result = readDouble(scanner, question);
        }

        return result;
    }
}
