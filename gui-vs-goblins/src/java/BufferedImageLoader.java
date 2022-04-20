import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedImageLoader {

    private BufferedImage level_image;
    private BufferedImage sprite_image;

    public BufferedImage loadLevel() {

        try {
            this.level_image = ImageIO.read(new FileInputStream("src/resources/goblins-world.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return level_image;
    }

    public BufferedImage loadSprite() {

        try {
            this.sprite_image = ImageIO.read(new FileInputStream("src/resources/sprite-sheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite_image;
    }
}
