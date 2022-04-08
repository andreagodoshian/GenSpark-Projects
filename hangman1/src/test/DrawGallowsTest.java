import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawGallowsTest {

    DrawGallows gallowsTest;

    @BeforeEach
    void setUp() {
        gallowsTest = new DrawGallows();
    }

    @Test
    void sixLives() {
        gallowsTest.drawHangman(6);
        assertEquals("""
                            |----------
                            |
                            |
                            |
                            |
                            *************""", gallowsTest.drawHangman(6));
    }

    @Test
    void fiveLives() {
        gallowsTest.drawHangman(5);
        assertEquals("""
                            |----------
                            |    O
                            |
                            |
                            |
                            *************""", gallowsTest.drawHangman(5));
    }

    @Test
    void fourLives() {
        gallowsTest.drawHangman(4);
        assertEquals("""
                            |----------
                            |    O
                            |    |
                            |
                            |
                            *************""", gallowsTest.drawHangman(4));
    }

    @Test
    void threeLives() {
        gallowsTest.drawHangman(3);
        assertEquals("""
                            |----------
                            |    O
                            |   -|
                            |
                            |
                            *************""", gallowsTest.drawHangman(3));
    }

    @Test
    void twoLives() {
        gallowsTest.drawHangman(2);
        assertEquals("""
                            |----------
                            |    O
                            |   -|-
                            |
                            |
                            *************""", gallowsTest.drawHangman(2));
    }

    @Test
    void oneLives() {
        gallowsTest.drawHangman(1);
        assertEquals("""
                            |----------
                            |    O
                            |   -|-
                            |   |
                            |
                            *************""", gallowsTest.drawHangman(1));
    }

    @Test
    void zeroLives() {
        gallowsTest.drawHangman(0);
        assertEquals("""
                            |----------
                            |    O
                            |   -|-
                            |   | |
                            |
                            *************""", gallowsTest.drawHangman(0));
    }

    @Test
    void elseForTest() {
        gallowsTest.drawHangman(76);
        assertEquals("""
                            |----------
                            |    O
                            |   -|-
                            |   | |
                            |
                            *************""", gallowsTest.drawHangman(76));
    }

    @AfterEach
    void tearDown(){

    }
}