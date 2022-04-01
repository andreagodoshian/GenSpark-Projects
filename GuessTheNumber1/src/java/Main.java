import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        GameFunctions compileMethods = new GameFunctions();
        boolean keepPlaying = true;
        String rawInput;
        int currentGuess;


        System.out.println("""
                Welcome to 'Guess The Number!'
                In this game, you will try to read my mind.
                Before we get started, can you tell me your name?
                
                *~please enter name below~*""");

        compileMethods.setName(input.next());
        String name = compileMethods.getName();

        while (keepPlaying) {

            System.out.println("\nReady to play, " + name + "?" +
                    "\nI am thinking of a number between 1 and 20...");

            Random r = new Random();
            int secretNumber = r.nextInt(1, 21);
            compileMethods.setAnswer(secretNumber);

            int count = 0;

            while (count < 6) {

                System.out.println("Please enter your guess below: ");

                // ensuring the guess is a digit
                while (true) {
                    rawInput = compileMethods.setGuess(input.next());

                    if (rawInput.equals("Please enter a digit.")) {
                        System.out.println(rawInput);
                    } else {break;}
                }

                // count increments, prior to "victory"
                count++;

                // retrieve the guess
                currentGuess = compileMethods.getGuess();


                // check for victory
                if (compileMethods.getStatus(currentGuess).equals("You won!")){
                    System.out.println("You won! Good job, " + name + "!" +
                            "\nAnd it only took you " + count + " guesses.\n");
                    break;
                } else {
                    System.out.println(compileMethods.getStatus(currentGuess));
                }

            }

            System.out.println("""
            Game over!
            Would you like to play again? (y or n)""");
            String moreGames = input.next();

            if (!moreGames.equals("y")){
                System.out.println("Thanks for playing! Goodbye.");
                keepPlaying = false;
            }

        }
    }
}
