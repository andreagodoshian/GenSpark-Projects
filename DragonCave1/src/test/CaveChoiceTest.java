import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaveChoiceTest {

    CaveChoice thisIsATest;

    @BeforeEach
    void setUp() {
        thisIsATest = new CaveChoice();
    }

    @Test
    void getDigit() {
        assertEquals("Works!", thisIsATest.getDigit("1"));
        assertEquals("Works!", thisIsATest.getDigit("76"));
        assertEquals("Please enter a digit.", thisIsATest.getDigit("a"));
        assertEquals("Please enter a digit.", thisIsATest.getDigit("$"));
    }

    @Test
    void getCave1() {
        thisIsATest.setCave(1);
        assertEquals("""
                    \nA large, scary dragon jumps in front of you!
                    The dragon eats you in one bite.
                    This is not Pinocchio - you do not survive.
                    RIP 💀""", thisIsATest.getCave());
    }

    @Test
    void getCave2() {
        thisIsATest.setCave(2);
        assertEquals("""
                    \nYou are quickly spotted by a beautiful, shiny dragon!
                    This dragon is happy to share their treasure with you.
                    Congratulations!""", thisIsATest.getCave());
    }

    @Test
    void getCave3() {
        thisIsATest.setCave(3);
        assertEquals("""
                    \nYou are lost. Hope you don't end up in a Mr. Ballen podcast.
                    [That being said, if you do survive,
                    you should check out the Mr. Ballen podcast!]""", thisIsATest.getCave());
    }

    @AfterEach
    void tearDown() {
    }
}