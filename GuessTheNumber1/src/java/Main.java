import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        boolean keepPlaying = true;
        String rawInput;
        int guessMain;

        GameFunctions game = new GameFunctions();
        var input = new Scanner(System.in);

        System.out.println("""
                Welcome to 'Guess The Number!'
                In this game, you will try to read my mind.
                Before we get started, can you tell me your name?
                
                *~please enter name below~*""");

        game.setName(input.next());
        String name = game.getName();

        while (keepPlaying) {

            System.out.println("\nReady to play, " + name + "?" +
                    "\nI am thinking of a number between 1 and 20...");

            Random r = new Random();
            int secretNumber = r.nextInt(1, 21);
            game.setStatus(secretNumber);

            int count = 0;

            while (count < 6) {

                System.out.println("Please enter your guess below: ");

                while (true) {
                    rawInput = game.setDigit(input.next());

                    if (rawInput.equals("Please enter a digit.")) {
                        System.out.println(rawInput);
                    } else {
                        guessMain = game.getDigit();
                        break;
                    }
                }

                count++;

                if (game.getStatus(count).equals("You won!")){
                    if (count != 1){
                        System.out.println("You won! Good job, " + name + "!" +
                                "\nAnd it only took you " + count + " guesses.\n");
                    } else {
                        System.out.println("You won! Good job, " + name + "!" +
                                "\nAnd it only took you " + count + " guess.\n");
                    }
                } else {
                    System.out.println(game.getStatus(count));
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
