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

    public String setDigit(String raw) {
        try {
            guess = Integer.parseInt(raw);
            return "Works!";
        } catch (Exception e) {
            return "Please enter a digit.";
        }
    }

    public int getDigit(){
        return guess;
    }

    public void setStatus(int secret){
        this.secret = secret;
    }

    public String getStatus(int count){
        if (guess < secret) {
            winOrLose = "Too low!\n";
        } else if (guess > secret) {
            winOrLose = "Too high!\n";
        } else if (guess == secret) {
            winOrLose = "You won!\n";
        }
        return winOrLose;
    }
}