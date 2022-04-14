import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    private String player;
    private String secretWord;
    private int lives;

    Set<Character> correctGuesses = new HashSet<>();
    private List<String> secretList;
    private String playersProgress;
    private List<Character> theBoneyard = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    private String currentGuess;

    Game (String player, String secretWord){
        this.player = player;
        this.secretWord = "poop";
    }

    public void setStage(int lives){
        this.lives = lives;

        secretList = Stream.of(secretWord.split(""))
                .map(elem -> elem).collect(Collectors.toList());

        playersProgress = Stream.of(secretWord.split(""))
                .map(elem -> "_").collect(Collectors.toList()).toString();
    }

    public void setLives(int lives){
        this.lives = lives;
    }

    public int getLives(){
        return lives;
    }

    public String getPlayersList(){
        return "Answer: " + playersProgress;
    }

    public String getBoneyard(){
        return "Already Guessed: " + theBoneyard.toString();
    }

    public void checkGuess(){
        String guess = input.next().toLowerCase();

        if (guess.length() != 1){
            System.out.println("One character at a time");
            checkGuess();
        } else if (!Character.isAlphabetic(guess.charAt(0))) {
            System.out.println("Please make your guess is alphabetic");
            checkGuess();
        } else if (theBoneyard.contains(guess)){
            System.out.println("You already guessed that");
            checkGuess();
        } else {
            this.currentGuess = guess;
            theBoneyard.add(currentGuess.charAt(0));
        }
    }

    public boolean updateIfSafe(){
        if (!secretList.contains(currentGuess)){
            return false;
        }

        correctGuesses.add(currentGuess.charAt(0));

        playersProgress = secretWord.chars().mapToObj(i -> correctGuesses.contains((char)i) ? (char)i : '_')
                .reduce(new StringBuilder(),
                        StringBuilder::append,
                        StringBuilder::append).toString();
        return true;
    }

    public String getSecretWord(){
        return secretWord;
    }

    public boolean solved(){
        if (secretWord.equals(playersProgress)){
            return true;
        }
        else {
            return false;
        }
    }

    public int updateScore(int currentScore){
        currentScore += (lives*10);
        return currentScore;
    }

    public void highScore(int finalScore){
        String filePath = "C:\\Users\\12489\\Desktop\\hangman_high_scores.txt";

        try{
            FileWriter fw = new FileWriter(filePath, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("Name: " + player +
                    ", Score: " + finalScore +
                    ", Date: " + new java.util.Date() + "\n");

            pw.close();
        } catch (Exception e){
            System.out.println("Error writing to file!");
        }


    }
}