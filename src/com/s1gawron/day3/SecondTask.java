package com.s1gawron.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SecondTask {

    public static void main(String[] args) {
        try {
            final Scanner scanner = new Scanner(new File("src/com/s1gawron/day3/puzzle-input.txt"));
            int badgesPrioritySum = 0;

            while (scanner.hasNextLine()) {
                final String firstBackpack = scanner.nextLine();
                final String secondBackpack = scanner.nextLine();
                final String thirdBackpack = scanner.nextLine();

                final Set<Character> firstBackpackSet = getSet(firstBackpack);
                final Set<Character> secondBackpackSet = getSet(secondBackpack);
                final Set<Character> thirdBackpackSet = getSet(thirdBackpack);

                //intersection of first two backpacks
                firstBackpackSet.retainAll(secondBackpackSet);

                //intersection of previous two with third one
                firstBackpackSet.retainAll(thirdBackpackSet);

                badgesPrioritySum += getCommonElementPriority(firstBackpackSet);
            }

            scanner.close();
            System.out.println("Sum: " + badgesPrioritySum);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file");
        }

    }

    private static Set<Character> getSet(final String backpackValue) {
        final Set<Character> set = new HashSet<>();

        for (char c : backpackValue.toCharArray()) {
            set.add(c);
        }

        return set;
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
