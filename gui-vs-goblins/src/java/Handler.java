import java.awt.*;
import java.util.*;

public class Handler {

    // collection of all objects
    LinkedList<GameObject> object = new LinkedList<>();

    // for responsive key input
    private boolean up = false, down = false, right = false, left = false;

    // ticks all objects stored in the LinkedList
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    // renders all objects stored in the LinkedList
    public void render (Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    // adds to LinkedList
    public void addObject(GameObject tempObject) {
        object.add(tempObject);
    }

    // removes from LinkedList
    public void removeObject(GameObject tempObject) {
        object.remove(tempObject);
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
}
