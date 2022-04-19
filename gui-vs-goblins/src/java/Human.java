import java.awt.*;

public class Human extends GameObject{

    // remember: implement, but dont create new
    Handler handler;

    public Human (int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
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
                    if (velX>0) {
                        velX=0;
                        x=tempObject.getX() - 32;
                    } else if (velX<0){
                        velX = 0;
                        x = tempObject.getX() + 32;
                    }
                    if (velY>0) {
                        velY=0;
                        y = tempObject.getY() - 48;
                    } else if (velY<0){
                        velY = 0;
                        y = tempObject.getY() + 48;
                    }
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 32, 48);

    }

    @Override
    public Rectangle getBounds() { // horizontal collision
        return new Rectangle(x, y, 32, 48);
    }
}