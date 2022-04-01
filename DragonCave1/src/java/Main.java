import java.util.Scanner;
public class Main {
    public static void main(String[] args){

        var input = new Scanner(System.in);
        CaveChoice compileMethods = new CaveChoice();
        String rawInput;

        System.out.println("""
                        Welcome To Dragon Cave!
                        =======================
                        
                        You are in a land full of dragons
                        In front of you, there are two caves.
                        One cave houses a friendly dragon...
                        the other has a mean dragon that will EAT YOU!
                        
                        Which cave do you choose?
                        *~Please enter 1 or 2 below~*""");


        while (true){
                rawInput = compileMethods.chooseCave(input.next());

                if (rawInput.equals("Please enter a digit.")){
                    System.out.println(rawInput);
                } else {
                    break;
                }
        }

        System.out.println("""
                You approach a cave...
                It is dark and spooky...""");


        String printCave = compileMethods.getCave();
        System.out.println(printCave);

    }
}
