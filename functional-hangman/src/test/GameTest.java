import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game testGame;

    @BeforeEach
    void setUp() {
        testGame = new Game("Mr. Ballen (test case)", "mysterious");
        // sorry but Mr. Ballen is my new favorite "stock name" for coding :P
        testGame.setStage(6);
    }

    @Test
    void setStage() {
        testGame.setStage(6);
        assertEquals("Answer: [_, _, _, _, _, _, _, _, _, _]", testGame.getPlayersProgress());
        assertEquals("[m, y, s, t, e, r, i, o, u, s]", testGame.getSecretList());
    }

    @Test
    void setLives() {
        testGame.setLives(5);
        assertEquals(5, testGame.getLives());
    }

    @Test // similar test, just making sure that an accidental negative won't crash it
    void getLives() {
        testGame.setLives(-5);
        assertEquals(0, testGame.getLives());
    }

    @Test
    void getPlayersProgress() {
        testGame.setGuessForTest("m");
        testGame.updateIfSafe();
        assertEquals("Answer: m_________", testGame.getPlayersProgress());

        testGame.setGuessForTest("s");
        testGame.updateIfSafe();
        assertEquals("Answer: m_s______s", testGame.getPlayersProgress());
    }

    @Test
    void getBoneyard() {
        testGame.setGuessForTest("m");
        testGame.setGuessForTest("z");

        assertEquals("Already Guessed: [m, z]", testGame.getBoneyard());
    }

    @Test
    void updateIfSafe() {
        testGame.setGuessForTest("M");
        assertEquals(true, testGame.updateIfSafe());
        testGame.setGuessForTest("Z");
        assertEquals(false, testGame.updateIfSafe());
        testGame.setGuessForTest("!");
        assertEquals(false, testGame.updateIfSafe());
    }

    @Test
    void getSecretWord() {
        assertEquals("mysterious", testGame.getSecretWord());
    }

    @Test
    void solved() {
        assertEquals(false, testGame.solved());
        testGame.setGuessForTest("m");
        testGame.updateIfSafe();
        testGame.setGuessForTest("y");
        testGame.updateIfSafe();
        testGame.setGuessForTest("s");
        testGame.updateIfSafe();
        testGame.setGuessForTest("t");
        testGame.updateIfSafe();
        testGame.setGuessForTest("e");
        testGame.updateIfSafe();
        testGame.setGuessForTest("r");
        testGame.updateIfSafe();
        testGame.setGuessForTest("i");
        testGame.updateIfSafe();
        testGame.setGuessForTest("o");
        testGame.updateIfSafe();
        testGame.setGuessForTest("u");
        testGame.updateIfSafe();
        assertEquals(true, testGame.solved());
    }

    @Test
    void updateScore() { // assume they have all six lives
        int newScore = testGame.updateScore(10); // in my game, everyone starts with ten points
        assertEquals(70, newScore);
    }

    @Test
    void highScore() { // high score contains "write method" & "read method" so i wont test separately
        testGame.highScore(76);
        // check csv && if no stack traces, then it's good
    }

    @AfterEach
    void tearDown() {
    }
}