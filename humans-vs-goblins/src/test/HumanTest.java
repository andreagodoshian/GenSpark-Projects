import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

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
        assertEquals(0, testHuman.getPosition());
        testHuman.setPosition(5);
        assertEquals(5, testHuman.getPosition());
    }

    @Test
    void setPosition() {
        testHuman.setPosition(20);
        assertEquals(0, testHuman.getPosition());
        testHuman.setPosition(-20);
        assertEquals(0, testHuman.getPosition());
    }


    @Test
    void getHealth() {
        assertEquals(100, testHuman.getHealth());
    }

    @Test
    void setHealth() {
        testHuman.setHealth(-1);
        assertEquals(0, testHuman.getHealth());
    }

    @Test
    void attackGoblin() {
        // this one is difficult to test because of the random...
        // so I'm just making sure the Goblin will die LOL
        testGoblin.setHealth(15);
        testHuman.attackGoblin(testGoblin);
        assertEquals(0, testGoblin.getHealth());
    }

    @Test
    void testToString() {
        assertEquals(" Human ", testHuman.toString());
    }

    @AfterEach
    void tearDown() {
    }
}