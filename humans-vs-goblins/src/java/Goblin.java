import java.nio.charset.StandardCharsets;

public class Goblin {

    private int position;
    private int attack;
    private int health;

    public Goblin(){
        this.position = 15;
        this.attack = 35;
        this.health = 75;
    }

    public Goblin(int position, int attack, int health){
        this.position = position;
        this.attack = attack;
        this.health = health;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attackHuman(Human human) {
        try {
            if (this.attack >= human.getHealth()) {
                human.setHealth(0);
            }
            else {
                human.setHealth(human.getHealth() - this.attack);
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
        byte[] goblinByteArr = " Goblin ".getBytes(StandardCharsets.UTF_8);

        return new String(goblinByteArr, StandardCharsets.UTF_8);
    }
}
