package com.s1gawron.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class FirstTask {

    public static void main(String[] args) {
        try {
            final Scanner scanner = new Scanner(new File("src/com/s1gawron/day4/puzzle-input.txt"));
            int commonSections = 0;

            while (scanner.hasNextLine()) {
                final String elvesPair = scanner.nextLine();
                final String[] elvesSections = elvesPair.split(",");
                final Integer[] firstElfSection = Arrays.stream(elvesSections[0].split("-")).map(Integer::valueOf).toArray(Integer[]::new);
                final Integer[] secondElfSection = Arrays.stream(elvesSections[1].split("-")).map(Integer::valueOf).toArray(Integer[]::new);
                final Set<Integer> allSections = new HashSet<>();

                for (int i = firstElfSection[0]; i <= firstElfSection[1]; i++) {
                    allSections.add(i);
                }

                for (int i = secondElfSection[0]; i <= secondElfSection[1]; i++) {
                    allSections.add(i);
                }

                final int firstElfSectionRange = firstElfSection[1] - firstElfSection[0] + 1;
                final int secondElfSectionRange = secondElfSection[1] - secondElfSection[0] + 1;

                if (firstElfSectionRange > secondElfSectionRange) {
                    if (firstElfSectionRange == allSections.size()) {
                        commonSections++;
                    }
                }

                if (secondElfSectionRange > firstElfSectionRange) {
                    if (secondElfSectionRange == allSections.size()) {
                        commonSections++;
                    }
                }

                if (firstElfSectionRange == allSections.size() && secondElfSectionRange == allSections.size()) {
                    commonSections++;
                }
            }

            scanner.close();
            System.out.println("Common sections: " + commonSections);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file");
        }
    }
}
