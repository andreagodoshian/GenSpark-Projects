import java.io.*;
import java.util.*;

public class GenerateWord {

    Random rand = new Random();
    private String secretWord;

    public void setSecretWord() {
        try {
            Scanner readDict = new Scanner(new File("C:\\Users\\12489\\Documents\\GenSpark-Projects\\hangman_words.txt"));
            List<String> dictionary = new ArrayList<>();

            while (readDict.hasNext()) {
                dictionary.add(readDict.nextLine());
            }
            secretWord = dictionary.get(rand.nextInt(dictionary.size()));
        } catch (Exception e) {
            System.out.println("""
                    Sorry, but we are unable to generate a secret word.
                    Please troubleshoot, or try again later. Goodbye.""");
            System.exit(1);
        }
    }

    public String getSecretWord() {
        return secretWord;
    }

}
