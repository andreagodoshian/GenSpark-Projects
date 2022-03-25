import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        boolean play = true;

        Scanner input = new Scanner(System.in);

        System.out.println("""
                Welcome to 'Guess The Number!'
                In this game, you will try to read my mind.
                Before we get started, can you tell me your name?
                
                *~please enter name below~*""");

        String name = input.next();

        while (play) {

            System.out.println("\nReady to play, " + name + "?" +
                    "\nI am thinking of a number between 1 and 20...");

            Random r = new Random();
            int secretNumber = r.nextInt(1, 21);

            int count = 0;

            while (count < 6) {
                System.out.println("Please enter your guess below: ");
                int guess = input.nextInt();

                if (guess < secretNumber) {
                    System.out.println("Too low!\n");
                    count++;
                } else if (guess > secretNumber) {
                    System.out.println("Too high!\n");
                    count++;
                } else if (guess == secretNumber) {
                    count++;

                    if (count != 1){
                        System.out.println("You won! Good job, " + name + "!" +
                                "\nAnd it only took you " + count + " guesses.\n");
                        break;
                    } else {
                        System.out.println("You won! Good job, " + name + "!" +
                                "\nAnd it only took you " + count + " guess.\n");
                        break;
                    }
                }
            }

            System.out.println("""
            Game over!
            Would you like to play again? (y or n)""");
            String keepPlaying = input.next();

            if (!keepPlaying.equals("y")){
                System.out.println("Thanks for playing! Goodbye.");
                play = false;
            }
        }
    }
}
