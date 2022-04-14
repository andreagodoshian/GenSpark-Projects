import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandTest {

    Human testHuman;
    Goblin testGoblin;
    Land testLand;

    @BeforeEach
    void setUp() {
        testHuman = new Human();
        testGoblin = new Goblin();
        testLand = new Land(" _____ ");
    }

    @Test
    void dramaticEffect() {
        // since it's a void sleeper, I'm just making sure it works
        testLand.dramaticEffect();
    }

    @Test
    void printMap() {
        assertEquals(" _____ ", testLand.gridArrayList.get(5));

        assertEquals(true, testLand.printMap(testLand.gridArrayList));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            testLand.gridArrayList.get(16);
        });
    }

    @Test
    void humanNorth() {
        testHuman.setPosition(8);
        testLand.humanNorth(testHuman);
        assertEquals(4, testHuman.getPosition());
    }

    @Test
    void humanSouth() {
        testLand.humanSouth(testHuman);
        assertEquals(4, testHuman.getPosition());
    }

    @Test
    void humanEast() {
        testLand.humanEast(testHuman);
        assertEquals(1, testHuman.getPosition());
    }

    @Test
    void humanWest() {
        testHuman.setPosition(1);
        testLand.humanWest(testHuman);
        assertEquals(0, testHuman.getPosition());
    }

    @Test
    void goblinNorth() {
        testLand.goblinNorth(testGoblin);
        assertEquals(11, testGoblin.getPosition());
    }

    @Test
    void goblinSouth() {
        testGoblin.setPosition(11);
        testLand.goblinSouth(testGoblin);
        assertEquals(15, testGoblin.getPosition());
    }

    @Test
    void goblinEast() {
        testGoblin.setPosition(14);
        testLand.goblinEast(testGoblin);
        assertEquals(15, testGoblin.getPosition());
    }

    @Test
    void goblinWest() {
        testLand.goblinWest(testGoblin);
        assertEquals(14, testGoblin.getPosition());
    }

    @Test
    void testToString() {
        assertEquals("In the Land of Death...", testLand.toString());
    }

    @AfterEach
    void tearDown() {
    }
}