package pl.coderslab;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Zadanie_4 {
    static int roll(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, "D+-");
        int x = 1;
        if (!input.startsWith("D")){
            x = Integer.parseInt(tokenizer.nextToken());
        }
        int y = Integer.parseInt(tokenizer.nextToken());
        int z = 0;
        if (tokenizer.hasMoreTokens()) {
            z = Integer.parseInt(tokenizer.nextToken());
            if (input.contains("-")) {
                z = -z;
                System.out.println(z);
            }
        }
        int sum = 0;
        Random random = new Random();
        for (int i = 0; i < x; i++) {
            sum += random.nextInt(y) + 1;
        }
        return sum + z;
    }

    public static void main(String[] args) {
        System.out.println("Wynik: " + roll("1D6-30"));
        //System.out.println("Wynik: " + roll("+10"));
        //System.out.println("Wynik: " + roll("1D6"));
    }
}