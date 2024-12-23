import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxNumber = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int totalAttempts = 0;
        int totalWins = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean continuePlaying = true;
        while (continuePlaying) {
            int secretNumber = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean roundWon = false;

            System.out.println("\nRound " + (rounds + 1));
            System.out.println("I'm thinking of a number between 1 and " + maxNumber + ". You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (or enter 'q' to quit): ");
                String guessInput = scanner.nextLine().trim();

                if (guessInput.equalsIgnoreCase("q")) {
                    System.out.println("Quitting game...");
                    continuePlaying = false;
                    break;
                }

                int guess;
                try {
                    guess = Integer.parseInt(guessInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }

                attempts++;
                totalAttempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempt(s).");
                    roundWon = true;
                    totalWins++;
                    break;
                }
            }

            if (!roundWon) {
                System.out.println("Sorry, you've run out of attempts. The number was " + secretNumber + ".");
            }

            rounds++;

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("\nGame over! You played " + rounds + " round(s) and won " + totalWins + " time(s).");
                System.out.println("Total attempts: " + totalAttempts);
                break;
            }
        }

        scanner.close();
    }
}
