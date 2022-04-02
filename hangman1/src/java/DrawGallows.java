public class DrawGallows {
    public void drawHangman(int l) {
        if(l == 6) {
            System.out.println("""
                            |----------
                            |
                            |
                            |
                            |
                            *************""");
        }
        else if(l == 5) {
            System.out.println("""
                            |----------
                            |    O
                            |
                            |
                            |
                            *************""");
        }
        else if(l == 4) {
            System.out.println("""
                            |----------
                            |    O
                            |    |
                            |
                            |
                            *************""");
        }
        else if(l == 3) {
            System.out.println("""
                            |----------
                            |    O
                            |   -|
                            |
                            |
                            *************""");
        }
        else if(l == 2) {
            System.out.println("""
                            |----------
                            |    O
                            |   -|-
                            |
                            |
                            *************""");
        }
        else if(l == 1) {
            System.out.println("""
                            |----------
                            |    O
                            |   -|-
                            |   |
                            |
                            *************""");
        }
        else{
            System.out.println("""
                            |----------
                            |    O
                            |   -|-
                            |   | |
                            |
                            *************""");
        }
    }
}
