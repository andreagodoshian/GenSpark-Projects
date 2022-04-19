public class Camera {

    // coordinates for the camera
    private float x, y;

    // the main constructor
    public Camera (float x, float y) {
        this.x = x;
        this.y = y;
    }

    // this "tick" is for following the player
    public void tick(GameObject object) {
        // special algorithm: locked on player, but not rigid
        // example: x = object.getX() + 1000/2
        x += ((object.getX() - x) - 1000/2) * 0.05f;
        y += ((object.getY() - y) - 565/2) * 0.05f;

        // this keeps the camera within the level
        if (x <= 0) x = 0;
        if (x >= 1045) x = 1045;
        if (y <= 0) y = 0;
        if (y >= 565+45) y = 565+45;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
