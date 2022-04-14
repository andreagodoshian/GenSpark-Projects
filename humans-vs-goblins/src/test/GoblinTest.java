import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {

    Human testHuman;
    Goblin testGoblin;

    @BeforeEach
    void setUp() {
        // testing the default stats (no custom params)
        testHuman = new Human();
        testGoblin = new Goblin();
    }

    @Test
    void getPosition() {
        assertEquals(15, testGoblin.getPosition());
        testGoblin.setPosition(5);
        assertEquals(5, testGoblin.getPosition());
    }

    @Test
    void setPosition() {
        testGoblin.setPosition(16);
        assertEquals(15, testGoblin.getPosition());
        testGoblin.setPosition(-16);
        assertEquals(15, testGoblin.getPosition());
    }

    @Test
    void getHealth() {
        assertEquals(75, testGoblin.getHealth());
    }

    @Test
    void setHealth() {
        testGoblin.setHealth(-1);
        assertEquals(0, testGoblin.getHealth());
    }

    @Test
    void attackHuman() {
        // this one is difficult to test because of the random...
        // so I'm just making sure the Human will die LOL
        testHuman.setHealth(33);
        testGoblin.attackHuman(testHuman);
        assertEquals(0, testHuman.getHealth());
    }

    @Test
    void testToString() {
        assertEquals(" Goblin ", testGoblin.toString());
    }

    @AfterEach
    void tearDown() {
    }

}