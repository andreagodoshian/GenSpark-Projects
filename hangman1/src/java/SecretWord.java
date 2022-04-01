import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SecretWord {
    Random rand = new Random();
    private String secretWord;
    private char[] secretArray;

    public void setSecretWord() throws FileNotFoundException {


        try {
            Scanner readDict = new Scanner(new File("C:\\Users\\12489\\Documents\\GenSpark-Projects\\hangman_words.txt"));
            List<String> dictionary = new ArrayList<>();

            while (readDict.hasNext()) {
                dictionary.add(readDict.nextLine());
            }
            secretWord = dictionary.get(rand.nextInt(dictionary.size()));
            secretArray = secretWord.toCharArray();
        } catch (Exception e) {
            secretWord = "error";
            secretArray = secretWord.toCharArray();
        }
    }

    public String getSecretWord() {
        return secretWord;
    }
}
