import java.util.*;
import java.io.*;

public class GenerateGraphics {
    private String gallows;
    private List<String> theGraphics = new ArrayList<>();

    GenerateGraphics(){
        try {
            Scanner graphicsFile = new Scanner(new File
                    ("C:\\Users\\12489\\Desktop\\hangman_art.txt"));
            while (graphicsFile.hasNext()){
                theGraphics.add(graphicsFile.nextLine());
            }
        } catch (Exception e){
            System.out.println("Error! Bye!");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public String drawGallows (int lives){
        if (lives >= 6){
            gallows = theGraphics.get(0) + "\n" + theGraphics.get(1) + "\n" +
                    theGraphics.get(2) + "\n" + theGraphics.get(3) + "\n" +
                    theGraphics.get(4) + "\n" + theGraphics.get(5);
        }

        else if (lives == 5){
            gallows = theGraphics.get(6) + "\n" + theGraphics.get(7) + "\n" +
                    theGraphics.get(8) + "\n" + theGraphics.get(9) + "\n" +
                    theGraphics.get(10) + "\n" + theGraphics.get(11);
        }

        else if (lives == 4){
            gallows = theGraphics.get(12) + "\n" + theGraphics.get(13) + "\n" +
                    theGraphics.get(14) + "\n" + theGraphics.get(15) + "\n" +
                    theGraphics.get(16) + "\n" + theGraphics.get(17);
        }

        if (lives == 3){
            gallows = theGraphics.get(18) + "\n" + theGraphics.get(19) + "\n" +
                    theGraphics.get(20) + "\n" + theGraphics.get(21) + "\n" +
                    theGraphics.get(22) + "\n" + theGraphics.get(23);
        }

        if (lives == 2){
            gallows = theGraphics.get(24) + "\n" + theGraphics.get(25) + "\n" +
                    theGraphics.get(26) + "\n" + theGraphics.get(27) + "\n" +
                    theGraphics.get(28) + "\n" + theGraphics.get(29);
        }

        if (lives == 1){
            gallows = theGraphics.get(30) + "\n" + theGraphics.get(31) + "\n" +
                    theGraphics.get(32) + "\n" + theGraphics.get(33) + "\n" +
                    theGraphics.get(34) + "\n" + theGraphics.get(35);
        }

        if (lives <= 0){
            gallows = theGraphics.get(36) + "\n" + theGraphics.get(37) + "\n" +
                    theGraphics.get(38) + "\n" + theGraphics.get(39) + "\n" +
                    theGraphics.get(40) + "\n" + theGraphics.get(41);
        }

        return gallows;
    }
}
