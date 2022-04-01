import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("""
                Welcome to the game of Hangman!
                You have six lives. Good luck.""");

        /////////////////////////////

        boolean keepPlaying = true;

        while (keepPlaying) {

            Scanner input = new Scanner(System.in);
            Hangman game = new Hangman();
            SecretWord generate = new SecretWord();
            // DrawGallows picture = new DrawGallows();

            generate.setSecretWord();
            String answer = generate.getSecretWord();
            char[] answerSplit = answer.toCharArray();
            game.setStage(answerSplit);

            int lives = 6;

            while (true) {
                System.out.println("""
                        *************************
                        Please enter your guess below""");

                String guess = input.next().toLowerCase();

                while (guess.length() != 1 || Character.isDigit(guess.charAt(0))) {
                    System.out.println("Please enter single letters only.");
                    guess = input.next().toLowerCase();
                }

                boolean alreadyGuessed = game.dogHouse(guess.charAt(0));

                while (alreadyGuessed){
                        System.out.println("You already guessed that. Try again.");
                        guess = input.next().toLowerCase();
                        alreadyGuessed = game.dogHouse(guess.charAt(0));
                    }


                boolean safe = game.strikeOrNot();

                game.updatePlayersArray();

                if (!safe) {
                    lives--;
                    System.out.println("Wrong letter.");
                }

                System.out.println(game.updatedArray());
                System.out.println("\nLives Left: " + lives);

                boolean solved = game.getStatus();

                if (solved) {
                    System.out.println("Congratulations! You found the word.");
                    break;
                }

                if (lives <= 0) {
                    System.out.println("You are dead! The correct answer was: " + answer);
                    break;
                }
            }

            System.out.println("Keep playing? Enter y or n below.");
            String moreGames = input.next().toLowerCase();

            if (moreGames.equals("y")) {
                System.out.println("Great! Let's play again!");

            } else {
                System.out.println("Thanks for playing! Goodbye for now.");
                keepPlaying = false;
                break;
            }

        }
    }
}