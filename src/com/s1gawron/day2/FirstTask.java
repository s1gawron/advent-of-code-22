package com.s1gawron.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

class FirstTask {

    private static final Map<String, String> LETTER_TO_SHAPE = Map.of("A", "Rock", "B", "Paper", "C", "Scissors", "X", "Rock", "Y", "Paper", "Z", "Scissors");

    private static final Map<String, Integer> SCORE_MAP = Map.of("Rock", 1, "Paper", 2, "Scissors", 3);

    public static void main(String[] args) {
        try {
            final Scanner scanner = new Scanner(new File("src/com/s1gawron/day2/puzzle-input.txt"));
            int myScore = 0;

            while (scanner.hasNextLine()) {
                final String battle = scanner.nextLine();
                final String[] choices = battle.split(" ");
                final String elfChoice = choices[0];
                final String myChoice = choices[1];

                myScore += myRoundPoints(LETTER_TO_SHAPE.get(elfChoice), LETTER_TO_SHAPE.get(myChoice));
            }

            scanner.close();
            System.out.println("My score: " + myScore);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file");
        }
    }

    private static int myRoundPoints(final String elfChoice, final String myChoice) {
        int roundScore = SCORE_MAP.get(myChoice);

        //draw
        if (elfChoice.equals(myChoice)) {
            roundScore += 3;
        }

        //win
        if (elfChoice.equals("Rock") && myChoice.equals("Paper")) {
            roundScore += 6;
        }

        //win
        if (elfChoice.equals("Paper") && myChoice.equals("Scissors")) {
            roundScore += 6;
        }

        //win
        if (elfChoice.equals("Scissors") && myChoice.equals("Rock")) {
            roundScore += 6;
        }

        return roundScore;
    }
}
