import javax.swing.*;
import java.awt.*;

/*
naturally, this creates the game window
*/

public class Window {

    public Window(int width, int height, String title, Game game) {

        // basics of the window
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        // adding the game to the window (Canvas)
        frame.add(game);
        frame.setResizable(false); // can't resize (possible graphic issues)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // makes window centered
        frame.setVisible(true); // lets ppl see the window

    }
}
