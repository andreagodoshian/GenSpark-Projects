public class CaveChoice {

    private int choice;
    private String specificCave;

    public String chooseCave(String raw) {
        try {
            choice = Integer.parseInt(raw);
            return "Works!";
        } catch (Exception e) {
            return "Please enter a digit.";
        }
    }

    // this function is primarily for testing
    public void setCave(int choice){
        this.choice = choice;
    }

    public String getCave() {
        if (choice == 1) {
            specificCave = """
                    \nA large, scary dragon jumps in front of you!
                    The dragon eats you in one bite.
                    This is not Pinocchio - you do not survive.
                    RIP 💀""";
            return specificCave;
        } else if (choice == 2) {
            specificCave = """
                    \nYou are quickly spotted by a beautiful, shiny dragon!
                    This dragon is happy to share their treasure with you.
                    Congratulations!""";
            return specificCave;
        } else {
            specificCave = """
                    \nYou are lost. Hope you don't end up in a Mr. Ballen podcast.
                    [That being said, if you do survive,
                    you should check out the Mr. Ballen podcast!]""";
            return specificCave;
        }

    }

}