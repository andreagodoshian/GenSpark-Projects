import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    // initialize handler, but don't create a new one!!
    Handler handler;

    // main constructor
    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // loops through all objects...
        for (int i = 0; i<handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            // ...if player, THEN move
            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) handler.setUp(true);
                if (key == KeyEvent.VK_S) handler.setDown(true);
                if (key == KeyEvent.VK_A) handler.setLeft(true);
                if (key == KeyEvent.VK_D) handler.setRight(true);
            }
        }
    }

    public void keyReleased (KeyEvent e) {
        // simple copy-pasta with edits
        int key = e.getKeyCode();

        // loops through all objects...
        for (int i = 0; i<handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            // ...if player, THEN release
            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) handler.setUp(false);
                if (key == KeyEvent.VK_S) handler.setDown(false);
                if (key == KeyEvent.VK_A) handler.setLeft(false);
                if (key == KeyEvent.VK_D) handler.setRight(false);
            }
        }
    }

}
