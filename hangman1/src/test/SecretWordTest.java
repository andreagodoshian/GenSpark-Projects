import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SecretWordTest {

    SecretWord wordTest;

    @BeforeEach
    void setUp() {
        wordTest = new SecretWord();
    }

    @Test
    void setSecretWord1() {
        wordTest.setSecretWord();
        String test = wordTest.getSecretWord();
        assertEquals(test, wordTest.getSecretWord());
    }

    @Test
    void setSecretWord2() {
        wordTest.setSecretWord();
        String test = wordTest.getSecretWord();
        assertEquals(test, wordTest.getSecretWord());
    }

    @Test
    void setSecretWord3() {
        wordTest.setSecretWord();
        String test = wordTest.getSecretWord();

        assertEquals(test, wordTest.getSecretWord());
    }

    @AfterEach
    void tearDown() {
    }

}