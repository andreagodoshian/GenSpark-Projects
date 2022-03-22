import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome To Dragon Cave!");
        System.out.println("=======================");
        System.out.println("\nYou are in a land full of dragons.");
        System.out.println("In front of you, there are two caves.");
        System.out.println("One cave houses a friendly dragon...");
        System.out.println("the other has a mean dragon that will eat you.");

        System.out.println("\nWhich cave will you go in?");
        System.out.println("Please enter 1 or 2: ");
        String choice = input.nextLine();
        int num = Integer.valueOf(choice);
        System.out.println("You approach a cave...");
        System.out.println("It is dark and spooky...\n");

        if (num == 1){
            System.out.println("A large dragon jumps in front of you!");
            System.out.println("The dragon eats you in one bite.");
        } else if (num == 2){
            System.out.println("You are quickly noticed by a shiny dragon!");
            System.out.println("This dragon is happy to share their treasure with you.");
        } else {
            System.out.println("You are lost. Better call Mr. Ballen asap.");
        }



    }
}
