import java.nio.charset.StandardCharsets;

public class Human {
    private int position;
    private int attack;
    private int health;

    public Human(){
        this.position = 0;
        this.attack = 25;
        this.health = 100;
    }

    public Human(int position, int attack, int health){
        this.position = position;
        this.attack = attack;
        this.health = health;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if (position>15 || position<0){
            this.position = 0;
            return;
        }
        this.position = position;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
            return;
        }
        this.health = health;
    }

    public void attackGoblin(Goblin goblin) {
        try {
            if (this.attack >= goblin.getHealth()) {
                goblin.setHealth(0);
            }
            else {
                goblin.setHealth(goblin.getHealth() - this.attack);
                int collateralDamage = (int)(Math.random() * 15);
                this.setHealth(this.getHealth() - collateralDamage);
            }
        } catch (Exception e) {
            System.out.println("""
                    In a shocking turn of events, the human and goblin
                    have agreed to peace! How inspiring. Goodbye""");
            System.exit(0);
        }

    }

    @Override
    public String toString() {
        byte[] humanByteArr = " Human ".getBytes(StandardCharsets.UTF_8);

        return new String(humanByteArr, StandardCharsets.UTF_8);
    }

}
