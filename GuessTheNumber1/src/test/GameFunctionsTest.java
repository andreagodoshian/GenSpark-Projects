import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameFunctionsTest {

    GameFunctions thisIsATest;

    @BeforeEach
    void setUp() {
        thisIsATest = new GameFunctions();
    }


    @Test
    void setName() {
        thisIsATest.setName("Andrea");
        assertEquals("Andrea", thisIsATest.getName());
        thisIsATest.setName("Надежда");
        assertEquals("Надежда", thisIsATest.getName());
    }

    @Test
    void getName() {
        thisIsATest.setName("$%^&*(#");
        assertEquals("$%^&*(#", thisIsATest.getName());
        thisIsATest.setName("123456");
        assertEquals("123456", thisIsATest.getName());
    }

    @Test
    void setAnswer() {
        thisIsATest.setAnswer(5);
        assertEquals(5, thisIsATest.getAnswer());
    }

    @Test
    void setGuess() {
        assertEquals("Works!", thisIsATest.setGuess("1"));
        assertEquals("Works!", thisIsATest.setGuess("76"));
        assertEquals("Please enter a digit.", thisIsATest.setGuess("a"));
        assertEquals("Please enter a digit.", thisIsATest.setGuess("$8"));
    }

    @Test
    void getGuess() {
        thisIsATest.setGuess("5");
        assertEquals(5, thisIsATest.getGuess());
        thisIsATest.setGuess("100");
        assertEquals(100, thisIsATest.getGuess());
    }

    @Test
    void getStatus() {
        thisIsATest.setAnswer(5);
        assertEquals("You won!", thisIsATest.getStatus(5));
        thisIsATest.setAnswer(5);
        assertEquals("Too low!", thisIsATest.getStatus(1));
        thisIsATest.setAnswer(5);
        assertEquals("Too high!", thisIsATest.getStatus(10));
    }

    @AfterEach
    void tearDown() {
    }

}