package org.zlasu.cd_warsztaty_1;

import org.zlasu.readConsole.ReadSystemConsole;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Zadanie_2 {

    private static final int RANGE = 49;
    private static final int PICK_NUMBER = 6;

    public static void main(String[] args) {
        int[] pickedNumbers = new int[PICK_NUMBER];
        int[] generetedNumbers = new int[PICK_NUMBER];

        pickedNumbers = getNumbersFromUser();
        generetedNumbers = generateNumbers();

        System.out.println("pickedNumbers :" + Arrays.toString(pickedNumbers));
        System.out.println("generetedNumbers :" + Arrays.toString(generetedNumbers));

        System.out.println("Trafileś: " + chackResult(pickedNumbers, generetedNumbers));
    }

    private static int chackResult(int[] pickedNumbers, int[] generetedNumbers) {
        int hits = 0;
        for (int i = 0; i < pickedNumbers.length; i++) {
            for (int j = 0; j < generetedNumbers.length; j++) {
                if (pickedNumbers[i] == generetedNumbers[j]) {
                    hits++;
                }
            }
        }

        return hits;
    }

    private static int[] generateNumbers() {
        Integer[] arr = new Integer[RANGE];
        int[] result = new int[PICK_NUMBER];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(arr));
        for (int i = 0; i < PICK_NUMBER; i++) {
            result[i] = arr[i];
        }

        Arrays.sort(result);

        return result;
    }

    private static int[] getNumbersFromUser() {
        Scanner scanner = new Scanner(System.in);
        int[] numbres = new int[PICK_NUMBER];

        for (int i = 0; i < numbres.length; i++) {
            numbres[i] = ReadSystemConsole.readPositiveInt(scanner, "Podaj typowaną liczbę nr " + (i + 1) + ": ");
            for (int j = 0; j < numbres.length; j++) {
                if (numbres[i] == numbres[j] && i != j) {
                    System.out.println("Już podałeś tą liczbę podaj inną.");
                    i--;
                    break;
                }
            }
            if (numbres[i] < 1 || numbres[i] > RANGE) {
                System.out.println("Liczba wikeszka od " + RANGE + " podaj inną.");
                i--;
            }
            System.out.println();
        }

        Arrays.sort(numbres);

        return numbres;
    }
}
