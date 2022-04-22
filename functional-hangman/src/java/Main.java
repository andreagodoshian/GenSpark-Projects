import java.util.*;

public class Main {

    GenerateWord generateWord;
    GenerateGraphics graphics;
    Game game;

    String name;
    int score = 10; // they get ten points just for playing, because why not
    Scanner input;

    public Main() {
        System.out.println("""
                Welcome to the game of Hangman!
                This version is only for one player.
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~""");

            input = new Scanner(System.in);
            System.out.println("Before we begin, please enter your name below:");
            name = input.nextLine();

            generateWord = new GenerateWord();
            generateWord.setSecretWord();

            graphics = new GenerateGraphics();

            game = new Game(name, generateWord.getSecretWord());
            game.setStage(6);

            while (true) {
                System.out.println(graphics.drawGallows(game.getLives()) +
                        "\nLives left:" + game.getLives() +
                        "\n" + game.getPlayersProgress() +
                        "\n" + game.getBoneyard() +
                        "\nPlease enter your guess below: ");

                game.checkGuess();

                if (!game.updateIfSafe()){
                    game.setLives(game.getLives() - 1);
                }

                if (game.solved() || game.getLives()<=0){
                    System.out.println(graphics.drawGallows(game.getLives()));

                    if (game.solved()){
                        System.out.println("YOU WON!");
                    } else {
                        System.out.println("YOU LOST!");
                    }

                    score = game.updateScore(score);

                    System.out.println("The answer was: " + game.getSecretWord() +
                            "\nYour current score is: " + score +
                            "\nPlay again? (y or n)");
                    String moreGames = input.next().toLowerCase();

                    if (moreGames.equals("y")) {
                        System.out.println("Great! Let's play again!");

                        generateWord = new GenerateWord();
                        generateWord.setSecretWord();

                        game = new Game(name, generateWord.getSecretWord());
                        game.setStage(6);

                    } else {
                        game.highScore(score);
                        System.out.println("Your score has been recorded!" +
                                "\nThanks for playing! Goodbye for now.");
                        break;
                    }
                }
        }
    }

    public static void main (String[] args){
        new Main();
    }
}
