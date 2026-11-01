package Practicals.Practical_01;

import java.util.Random;
import java.util.Scanner;

public class RPSLS {

    // (a) Enum for move options
    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    // (b) Returns 1 if 'a' wins, -1 if 'b' wins, 0 for tie
    public static int winner(Move a, Move b) {

        if (a == b) {
            return 0;
        }

        boolean aWins = switch (a) {

            case SCISSORS ->
                (b == Move.PAPER || b == Move.LIZARD);

            case PAPER ->
                (b == Move.ROCK || b == Move.SPOCK);

            case ROCK ->
                (b == Move.LIZARD || b == Move.SCISSORS);

            case LIZARD ->
                (b == Move.SPOCK || b == Move.PAPER);

            case SPOCK ->
                (b == Move.SCISSORS || b == Move.ROCK);
        };

        return aWins ? 1 : -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Move[] moves = Move.values();

        int playerScore = 0;
        int computerScore = 0;

        System.out.println("=== Rock-Paper-Scissors-Lizard-Spock ===");

        // (c) Play 5 rounds
        for (int round = 1; round <= 5; round++) {

            System.out.println("\n--- Round " + round + " ---");

            // Computer picks random move
            Move computerMove = moves[random.nextInt(moves.length)];

            System.out.print(
                "Enter your move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): "
            );

            String input = scanner.next().toUpperCase();

            Move playerMove;

            try {
                playerMove = Move.valueOf(input);

            } catch (IllegalArgumentException e) {

                System.out.println(
                    "Invalid move! You forfeit this round."
                );

                computerScore++;
                continue;
            }

            System.out.println("You played: " + playerMove);
            System.out.println("Computer played: " + computerMove);

            int result = winner(playerMove, computerMove);

            if (result == 1) {

                System.out.println("Outcome: You win this round!");
                playerScore++;

            } else if (result == -1) {

                System.out.println("Outcome: Computer wins this round!");
                computerScore++;

            } else {

                System.out.println("Outcome: It's a tie!");
            }
        }

        // (d) Print overall result
        System.out.println("\n==================================");

        System.out.println(
            "Final Result: You "
            + (playerScore >= computerScore ? "win" : "lose")
            + " "
            + playerScore
            + "-"
            + computerScore
        );

        System.out.println("==================================");

        scanner.close();
    }
}
