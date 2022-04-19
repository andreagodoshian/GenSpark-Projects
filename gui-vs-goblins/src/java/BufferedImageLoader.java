import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedImageLoader {

    private BufferedImage image;

    public BufferedImage loadImage() {

        try {
            this.image = ImageIO.read(new FileInputStream("src/resources/goblins-world.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
}
