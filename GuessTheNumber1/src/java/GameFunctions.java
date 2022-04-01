public class GameFunctions {
    private String name;
    private int guess;
    private int secret;
    private String winOrLose;

    public void setName(String raw){
        this.name = raw;
    }

    public String getName(){
        return name;
    }

    public void setAnswer(int secret){
        this.secret = secret;
    }

    // this one is for testing
    public int getAnswer(){
        return secret;
    }

    public String setGuess(String raw) {
        try {
            guess = Integer.parseInt(raw);
            return "Works!";
        } catch (Exception e) {
            return "Please enter a digit.";
        }
    }

    public int getGuess(){
        return guess;
    }

    public String getStatus(int guess){
        if (guess < secret) {
            winOrLose = "Too low!";
        } else if (guess > secret) {
            winOrLose = "Too high!";
        } else if (guess == secret) {
            winOrLose = "You won!";
        }
        return winOrLose;
    }
}