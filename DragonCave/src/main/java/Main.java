import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("""
                        Welcome To Dragon Cave!
                        =======================
                        
                        You are in a land full of dragons
                        In front of you, there are two caves.
                        One cave houses a friendly dragon...
                        the other has a mean dragon that will EAT YOU!
                        
                        Which cave do you choose?
                        *~Please enter 1 or 2 below~*""");

        int choice = input.nextInt();

        System.out.println("""
                You approach a cave...
                It is dark and spooky...""");

        if (choice == 1){
            System.out.println("""
                    \nA large, scary dragon jumps in front of you!
                    The dragon eats you in one bite.
                    This is not Pinocchio - you do not survive.
                    RIP 💀""");
        } else if (choice == 2){
            System.out.println("""
                    \nYou are quickly spotted by a beautiful, shiny dragon!
                    This dragon is happy to share their treasure with you.
                    Congratulations!""");
        } else {
            System.out.println("""
                    \nYou are lost. Hope you don't end up in a Mr. Ballen video.
                    [That being said, if you do survive,
                    you should check out Mr. Ballen on YouTube!]""");
        }
    }
}
