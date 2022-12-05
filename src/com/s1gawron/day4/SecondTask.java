package com.s1gawron.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class SecondTask {

    public static void main(String[] args) {
        try {
            final Scanner scanner = new Scanner(new File("src/com/s1gawron/day4/puzzle-input.txt"));
            int overlapCounter = 0;

            while (scanner.hasNextLine()) {
                final String elvesPair = scanner.nextLine();
                final String[] elvesSections = elvesPair.split(",");
                final Integer[] firstElfSection = Arrays.stream(elvesSections[0].split("-")).map(Integer::valueOf).toArray(Integer[]::new);
                final Integer[] secondElfSection = Arrays.stream(elvesSections[1].split("-")).map(Integer::valueOf).toArray(Integer[]::new);
                final Set<Integer> firstElfSectionSet = new HashSet<>();
                final Set<Integer> secondElfSectionSet = new HashSet<>();

                for (int i = firstElfSection[0]; i <= firstElfSection[1]; i++) {
                    firstElfSectionSet.add(i);
                }

                for (int i = secondElfSection[0]; i <= secondElfSection[1]; i++) {
                    secondElfSectionSet.add(i);
                }

                firstElfSectionSet.retainAll(secondElfSectionSet);

                if (!firstElfSectionSet.isEmpty()) {
                    overlapCounter++;
                }
            }

            scanner.close();
            System.out.println("All overlaps: " + overlapCounter);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file");
        }
    }
}
