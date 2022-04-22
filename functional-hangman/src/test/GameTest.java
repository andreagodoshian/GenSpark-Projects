import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game testGame;

    @BeforeEach
    void setUp() {
        testGame = new Game("Mr. Ballen", "mysterious");
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
    }

    @Test
    void getSecretWord() {
    }

    @Test
    void solved() {
    }

    @Test
    void updateScore() {
    }

    @Test
    void highScore() {
    }

    @Test
    void writeToCSV() {
    }

    @Test
    void readCSV() {
    }

    @AfterEach
    void tearDown() {
    }
}