package com.s1gawron.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstTask {

    public static void main(String[] args) {
        try {
            final Scanner scanner = new Scanner(new File("src/com/s1gawron/day3/puzzle-input.txt"));
            int commonElementsPrioritySum = 0;

            while (scanner.hasNextLine()) {
                final String backpackItems = scanner.nextLine();
                final int itemsCount = backpackItems.length() / 2;
                final String backpackFirstCompartment = backpackItems.substring(0, itemsCount);
                final String backpackSecondCompartment = backpackItems.substring(itemsCount);

                final Set<Character> firstCompartmentSet = new HashSet<>();

                for (char c : backpackFirstCompartment.toCharArray()) {
                    firstCompartmentSet.add(c);
                }

                final Set<Character> secondCompartmentSet = new HashSet<>();

                for (char c : backpackSecondCompartment.toCharArray()) {
                    secondCompartmentSet.add(c);
                }

                firstCompartmentSet.retainAll(secondCompartmentSet);

                commonElementsPrioritySum += getCommonElementPriority(firstCompartmentSet);
            }

            System.out.println("Sum: " + commonElementsPrioritySum);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file");
        }

    }

    private static int getCommonElementPriority(final Set<Character> set) {
        //p - 112 (ASCII) p - 16 (task) = -96
        //L - 76 (ASCII) L - 38 (task) = -38

        int priority = 0;

        //one element in set
        for (final char c : set) {
            if (Character.isLowerCase(c)) {
                priority = (int) c - 96;
            }

            if (Character.isUpperCase(c)) {
                priority = (int) c - 38;
            }
        }

        return priority;
    }

}
