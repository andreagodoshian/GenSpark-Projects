public class DrawGallows {
    private String theGallows;

    public String drawHangman(int l) {
        if(l == 6) {
            theGallows = """
                            |----------
                            |
                            |
                            |
                            |
                            *************""";
        }
        else if(l == 5) {
            theGallows = """
                            |----------
                            |    O
                            |
                            |
                            |
                            *************""";
        }
        else if(l == 4) {
            theGallows = """
                            |----------
                            |    O
                            |    |
                            |
                            |
                            *************""";
        }
        else if(l == 3) {
            theGallows = """
                            |----------
                            |    O
                            |   -|
                            |
                            |
                            *************""";
        }
        else if(l == 2) {
            theGallows = """
                            |----------
                            |    O
                            |   -|-
                            |
                            |
                            *************""";
        }
        else if(l == 1) {
            theGallows = """
                            |----------
                            |    O
                            |   -|-
                            |   |
                            |
                            *************""";
        }
        else{
            theGallows = """
                            |----------
                            |    O
                            |   -|-
                            |   | |
                            |
                            *************""";
        }

        return theGallows;
    }
}
