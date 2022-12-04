package com.s1gawron.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class SecondTask {

    private static final Map<String, String> LETTER_TO_SHAPE = Map.of("A", "Rock", "B", "Paper", "C", "Scissors");

    private static final Map<String, String> ROUND_RESULT = Map.of("X", "Loss", "Y", "Draw", "Z", "Win");

    private static final Map<String, String> WIN_STRATEGY = Map.of("Rock", "Scissors", "Paper", "Rock", "Scissors", "Paper");

    private static final Map<String, Integer> SCORE_MAP = Map.of("Rock", 1, "Paper", 2, "Scissors", 3);

    public static void main(String[] args) {
        try {
            final Scanner scanner = new Scanner(new File("src/com/s1gawron/day2/puzzle-input.txt"));
            int myScore = 0;

            while (scanner.hasNextLine()) {
                final String battle = scanner.nextLine();
                final String[] choices = battle.split(" ");
                final String elfChoice = choices[0];
                final String roundResult = choices[1];

                myScore += myRoundPoints(LETTER_TO_SHAPE.get(elfChoice), ROUND_RESULT.get(roundResult));
            }

            scanner.close();
            System.out.println("My score: " + myScore);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file");
        }
    }

    private static int myRoundPoints(final String elfChoice, final String roundResult) {
        int roundPoints = 0;

        if (roundResult.equals("Win")) {
            roundPoints += 6;

            //swap keys with values (make LOSS_STRATEGY)
            final String myPick = WIN_STRATEGY.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey)).get(elfChoice);
            roundPoints += SCORE_MAP.get(myPick);
        }

        if (roundResult.equals("Draw")) {
            roundPoints += 3;
            roundPoints += SCORE_MAP.get(elfChoice);
        }

        if (roundResult.equals("Loss")) {
            final String myPick = WIN_STRATEGY.get(elfChoice);
            roundPoints += SCORE_MAP.get(myPick);
        }

        return roundPoints;
    }
}
