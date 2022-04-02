import java.util.*;

public class Hangman {
    private boolean solved = false;
    private boolean safe;

    private char[] secretArray;
    private char[] progressArray;

    private char guess;
    private ArrayList<Character> theBoneyard = new ArrayList<>();

    ////////////////////////////////////////////////

    public void setStage(char[]answer){
        this.secretArray = answer;

        progressArray = new char[secretArray.length];
        for (int i = 0; i < progressArray.length; i++) {
            progressArray[i] = '_';
        }
    }

    ////////////////////////////////////////////////

    public ArrayList<Character> returnBoneyard(){
        return theBoneyard;
    }

    public String showProgress() {
        return Arrays.toString(progressArray);
    }

    public String showAnswer(){
        return Arrays.toString(secretArray);
    }

    ////////////////////////////////////////////////

    public boolean checkBoneyard (char x){
        this.guess = x;

        List secretList = Arrays.asList(secretArray);

        if (theBoneyard.contains(guess)){
            return true;
        } else {
            theBoneyard.add(guess);
            return false;
        }
    }

    public void updatePlayersArray(){
        for (int i = 0; i<secretArray.length; i++){
            if (guess == secretArray[i]){
                progressArray[i] = secretArray[i];
            }
        }
    }

    public boolean strikeOrNot(){
        safe = false;

        for (int i = 0; i<secretArray.length; i++) {
            if (guess == secretArray[i]) {
                safe = true;
            }
        }
        return safe;
    }

}
