import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Handler;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    Hangman hangmanTest = new Hangman();

    @BeforeEach
    void setUp(){
        hangmanTest.setStage("answer");
        hangmanTest.checkBoneyard('a');
        hangmanTest.updatePlayersArray();
    }


    @Test
    void returnBoneyard() {
        ArrayList<Character> testBoneyard = new ArrayList<>();
        testBoneyard.add(0, 'a');
        assertEquals(testBoneyard, hangmanTest.returnBoneyard());
    }

    @Test
    void showProgress() {
        char[] testProgress = new char[6];
        for(int i = 0; i<6; i++){
            testProgress[i] = '_';
        }
        testProgress[0] = 'a';
        assertEquals(Arrays.toString(testProgress), hangmanTest.showProgress());
    }

    @Test
    void showAnswer() {
        char[] testAnswer = "answer".toCharArray();
        assertEquals(Arrays.toString(testAnswer), hangmanTest.showAnswer());

    }

    @Test
    void checkBoneyard() {
        assertEquals(false, hangmanTest.checkBoneyard('x'));
        assertEquals(true, hangmanTest.checkBoneyard('a'));
    }

    @Test
    void strikeOrNot() {
        hangmanTest.checkBoneyard('y');
        hangmanTest.updatePlayersArray();
        assertEquals(false, hangmanTest.safeOrNot());

        hangmanTest.checkBoneyard('n');
        hangmanTest.updatePlayersArray();
        assertEquals(true, hangmanTest.safeOrNot());

        hangmanTest.checkBoneyard('s');
        hangmanTest.updatePlayersArray();
        assertEquals(true, hangmanTest.safeOrNot());
    }
}