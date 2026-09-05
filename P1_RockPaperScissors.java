import java.util.Random;
import java.util.Scanner;

public class P1_RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] predefinedPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"}; // Live demo inputs
        Random random = new Random();

        int rounds = 5;
        int wins = 0, losses = 0, draws = 0;

        String[][] roundData = new String[rounds][4];

        for (int i = 0; i < rounds; i++) {
            String playerMove = predefinedPlayerMoves[i];
            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            roundData[i][0] = String.valueOf(i + 1);
            roundData[i][1] = playerMove;
            roundData[i][2] = computerMove;
            roundData[i][3] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        // Print Summary Table
        System.out.println(String.format("%-8s | %-12s | %-13s | %-13s", "Round", "Player Move", "Computer Move", "Result"));
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.println(String.format("%-8s | %-12s | %-13s | %-13s", roundData[i][0], roundData[i][1], roundData[i][2], roundData[i][3]));
        }

        double winPercentage = ((double) wins / rounds) * 100;
        System.out.println("\nFinal Summary (after " + rounds + " rounds)");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }
}
