import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenerateWordTest {

    GenerateWord testWord;

    @BeforeEach
    void setUp() {
        testWord = new GenerateWord();
    }

    @Test
    void generatingWordFromDocument1() {
        testWord.setSecretWord();
        String secretWord = testWord.getSecretWord();
        assertEquals(secretWord, testWord.getSecretWord());
    }

    @Test
    void generatingWordFromDocument2() {
        testWord.setSecretWord();
        String secretWord = testWord.getSecretWord();
        assertEquals(secretWord, testWord.getSecretWord());
    }

    @Test
    void testingGameLoop() {
        testWord.setSecretWord();
        String secretWord = testWord.getSecretWord();
        assertEquals(secretWord, testWord.getSecretWord());

        // in the game loop, this is how i "refresh"
        testWord = new GenerateWord();
        testWord.setSecretWord();
        secretWord = testWord.getSecretWord();
        assertEquals(secretWord, testWord.getSecretWord());

        // one more for good luck lol
        testWord = new GenerateWord();
        testWord.setSecretWord();
        secretWord = testWord.getSecretWord();
        assertEquals(secretWord, testWord.getSecretWord());
    }

    @AfterEach
    void tearDown() {
    }
}