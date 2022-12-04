package com.s1gawron.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FirstTask {

    public static void main(String[] args) {
        try {
            final Scanner scanner = new Scanner(new File("src/com/s1gawron/day1/puzzle-input.txt"));
            final List<Integer> results = new ArrayList<>();
            int currentSum = 0;

            while (scanner.hasNextLine()) {
                final String currentLine = scanner.nextLine();

                if (currentLine.trim().isEmpty()) {
                    results.add(currentSum);
                    currentSum = 0;
                    continue;
                }

                currentSum += Integer.parseInt(currentLine);
            }

            scanner.close();

            int max = results.get(0);

            for (int result : results) {
                if (result > max) {
                    max = result;
                }
            }

            System.out.println("Max: " + max);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file");
        }
    }
}
