import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateGraphicsTest {

    GenerateGraphics testGraphics;

    @BeforeEach
    void setUp() {
        testGraphics = new GenerateGraphics();
    }

    @Test
    void sixLives() {
        testGraphics.drawGallows(6);
        assertEquals("""
                            |----------
                            |
                            |
                            |
                            |
                            **************""", testGraphics.drawGallows(6));
    }

    @Test
    void fiveLives() {
        testGraphics.drawGallows(5);
        assertEquals("""
                |----------
                |    O
                |
                |
                |
                **************""", testGraphics.drawGallows(5));
    }

    @Test
    void fourLives() {
        testGraphics.drawGallows(4);
        assertEquals("""
                |----------
                |    O
                |    |
                |
                |
                **************""", testGraphics.drawGallows(4));
    }

    @Test
    void threeLives() {
        testGraphics.drawGallows(3);
        assertEquals("""
                |----------
                |    O
                |   -|
                |
                |
                **************""", testGraphics.drawGallows(3));
    }

    @Test
    void twoLives() {
        testGraphics.drawGallows(2);
        assertEquals("""
                |----------
                |    O
                |   -|-
                |
                |
                **************""", testGraphics.drawGallows(2));
    }

    @Test
    void oneLives() {
        testGraphics.drawGallows(1);
        assertEquals("""
                |----------
                |    O
                |   -|-
                |   |
                |
                **************""", testGraphics.drawGallows(1));
    }

    @Test
    void zeroLives() {
        testGraphics.drawGallows(0);
        assertEquals("""
                |----------
                |    O
                |   -|-
                |   | |
                |
                **************""", testGraphics.drawGallows(0));
    }

    @Test
    // just in case??
    void negativeLivesTest() {
        testGraphics.drawGallows(-76);
        assertEquals("""
                            |----------
                            |    O
                            |   -|-
                            |   | |
                            |
                            **************""", testGraphics.drawGallows(-76));
    }

    @Test
    void tooManyLives() {
        testGraphics.drawGallows(76);
        assertEquals("""
                            |----------
                            |
                            |
                            |
                            |
                            **************""", testGraphics.drawGallows(76));
    }

    @AfterEach
    void tearDown(){

    }
}