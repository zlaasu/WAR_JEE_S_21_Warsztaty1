package org.zlasu.cd_warsztaty_1;

import org.zlasu.readConsole.ReadSystemConsole;

import java.util.Random;
import java.util.Scanner;

public class Zadanie_1 {
    private static final int RANDOM_RANGE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(RANDOM_RANGE) + 1;
        int userNumber = 0;

        System.out.println("Wylosowałem liczbę zgadnij!!!." + randomNumber);

        while (randomNumber != userNumber) {
            userNumber = ReadSystemConsole.readPositiveInt(scanner, "Zgadnij liczbę");
            if (userNumber > randomNumber) {
                System.out.println("Za mało!");
            }
            if (userNumber < randomNumber) {
                System.out.println("Za dużo!");
            }
        }

        System.out.println("Brawo!!!");

    }
}
