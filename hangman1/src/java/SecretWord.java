import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SecretWord {

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
            secretWord = "error";
        }
    }

    public String getSecretWord() {
        return secretWord;
    }

}
