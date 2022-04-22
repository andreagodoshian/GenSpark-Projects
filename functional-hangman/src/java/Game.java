import java.io.*;
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
        this.secretWord = secretWord;
    }

    public void setStage(int lives){
        this.lives = lives;

        secretList = Stream.of(secretWord.split(""))
                .map(elem -> elem).collect(Collectors.toList());

        playersProgress = Stream.of(secretWord.split(""))
                .map(elem -> "_").collect(Collectors.toList()).toString();
    }


    public void setLives(int lives){
        if (lives < 0) lives = 0;
        this.lives = lives;
    }

    public int getLives(){
        return lives;
    }

    public String getPlayersProgress(){
        return "Answer: " + playersProgress;
    }

    // for testing
    protected String getSecretList() {return secretList.toString();}

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
        } else if (theBoneyard.contains(guess.charAt(0))){
            System.out.println("You already guessed that");
            checkGuess();
        } else {
            this.currentGuess = guess;
            theBoneyard.add(currentGuess.charAt(0));
        }
    }

    protected void setGuessForTest (String guess) {
        this.currentGuess = guess.toLowerCase();
        theBoneyard.add(currentGuess.charAt(0));
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
        String filePath = "src/resources/hangman_high_scores.csv";

        readCSV(filePath, finalScore);
        writeToCSV(filePath, finalScore);
    }

    public void writeToCSV(String filePath, int finalScore) {

        try{
            FileWriter fw = new FileWriter(filePath, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.write(player + ",");
            pw.write(finalScore + ",");
            pw.write(new java.util.Date() + "\n");

            pw.close();
        } catch (Exception e){
            System.out.println("""
                    Sorry, but we are unable to work with the High Score file.
                    For more information, please take a look at the stacktrace:""");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void readCSV(String filePath, int finalScore) {
        ArrayList<Integer> allScores = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                allScores.add(Integer.parseInt(values[1]));
            }
        } catch (NoSuchElementException e){
        } catch (Exception e){
            System.out.println("""
                    Sorry, but we are unable to work with the High Score file.
                    For more information, please take a look at the stacktrace:""");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            int previousHigh = allScores.stream().max(Integer::compare).get();
            if (finalScore > previousHigh) {
                System.out.println("YOU HAVE A NEW HIGH SCORE! CONGRATULATIONS!");
            }
        } catch (Exception e) {
        }
    }
}