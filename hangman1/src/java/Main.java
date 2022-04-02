import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("""
                
                Welcome to the game of Hangman!
                You have six lives. Good luck.
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                """);

        /////////////////////////////

        boolean keepPlaying = true;

        while (keepPlaying) {

            Scanner input = new Scanner(System.in);
            Hangman game = new Hangman();
            SecretWord generate = new SecretWord();
            DrawGallows pic = new DrawGallows();

            generate.setSecretWord();
            String answer = generate.getSecretWord();
            char[] answerSplit = answer.toCharArray();
            game.setStage(answerSplit);

            int lives = 6;

            while (true) {
                pic.drawHangman(lives);
                System.out.println("Already guessed: " + game.returnBoneyard());
                System.out.println("The word: " + game.showProgress());

                System.out.println("\nPlease enter your guess below");
                String guess = input.next().toLowerCase();

                while (guess.length() != 1 || Character.isDigit(guess.charAt(0))) {
                    System.out.println("Please enter single letters only.");
                    guess = input.next().toLowerCase();
                }

                boolean contains = game.checkBoneyard(guess.charAt(0));

                while (contains){
                        System.out.println("You already guessed that. Try again.");
                        guess = input.next().toLowerCase();
                        contains = game.checkBoneyard(guess.charAt(0));
                    }

                game.updatePlayersArray();

                boolean safe = game.strikeOrNot();

                if (!safe) {
                    lives--;
                }

                System.out.println("\nLives Left: " + lives);

                if (game.showProgress().equals(game.showAnswer())) {
                    pic.drawHangman(lives);
                    System.out.println("Congratulations! You found the word.");
                    break;
                }

                if (lives <= 0) {
                    pic.drawHangman(lives);
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