import java.util.ArrayList;

public class Hangman {
    private boolean solved = false;
    private boolean safe;

    private char[] secretArray;
    private char[] usersArray;

    private char guess;
    private ArrayList<Character> listOfMisses = new ArrayList<>();

    public void setStage(char[]secretArray){
        this.secretArray = secretArray;
        usersArray = new char[secretArray.length];

        for (int i = 0; i < usersArray.length; i++) {
            usersArray[i] = '_';
        }
    }

    public boolean dogHouse (char guess){
        this.guess = guess;

        if (listOfMisses.contains(guess)){
            return true;
        } else{
            listOfMisses.add(guess);
            return false;
        }
    }

    public void updatePlayersArray(){
        for (int i = 0; i<secretArray.length; i++){
            if (guess == secretArray[i]){
                usersArray[i] = secretArray[i];
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

    public char[] updatedArray(){
        return usersArray;
    }

    public boolean getStatus(){
        if (usersArray.equals(secretArray)){
            solved = true;
        }
        return solved;
    }
}
