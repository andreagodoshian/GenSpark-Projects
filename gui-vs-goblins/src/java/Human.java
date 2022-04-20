import java.awt.*;
import java.awt.image.BufferedImage;

public class Human extends GameObject{

    // remember: implement, but dont create new
    Handler handler;
    Game game;

    private BufferedImage human_image;

    public Human (int x, int y, ID id, Handler handler, Game game, SpriteSheet ss) {
        super(x, y, id, ss);
        this.handler = handler;
        this.game = game;

        human_image = ss.grabImage(1, 1, 32, 48);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        collision();

        /*
        to reduce lag & make more responsive
        */

        if(handler.isUp()) velY = -5;
        else if (!handler.isDown()) velY = 0;

        if (handler.isDown()) velY = 5;
        else if (!handler.isUp()) velY = 0;

        if (handler.isRight()) velX = 5;
        else if (!handler.isLeft()) velX = 0;

        if (handler.isLeft()) velX = -5;
        else if (!handler.isRight()) velX = 0;
    }

    // not pixel perfect, but a simple answer to a complex question
    private void collision() {
        for (int i = 0; i<handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Block) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    x += velX * -1;
                    y += velY * -1;
                }
            }

            if (tempObject.getId() == ID.Crate) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    game.ammo += 10;
                    handler.removeObject(tempObject);
                }
            }

            if (tempObject.getId() == ID.Enemy) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    game.hp--;
                    if (game.hp <= 0) {
                        handler.removeObject(this);
                    }
                }
            }




        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(human_image, x, y, null);
    }

    @Override
    public Rectangle getBounds() { // horizontal collision
        return new Rectangle(x, y, 32, 48);
    }
}