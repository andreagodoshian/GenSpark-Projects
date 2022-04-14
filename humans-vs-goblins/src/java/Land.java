import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Land {

    ArrayList<Object> gridArrayList = new ArrayList<>();

    public Land(String blanks){
        for(int i = 0; i < 16; i++) {
            gridArrayList.add(blanks);
        }
    }

    public void dramaticEffect(){
        try{
            Thread.sleep(700);
        } catch (Exception e){
            // empty lol
        }
    }

    public boolean printMap(ArrayList<Object> map){
        try {
            for(int i = 0; i < 4; i++) {
                System.out.print(map.get(i));
            }
            System.out.println();
            for(int i = 4; i < 8; i++) {
                System.out.print(map.get(i));
            }
            System.out.println();
            for(int i = 8; i < 12; i++) {
                System.out.print(map.get(i));
            }
            System.out.println();
            for(int i = 12; i < 16; i++) {
                System.out.print(map.get(i));
            }
            System.out.println();
            return true;
        } catch (Exception e) {
            System.out.println("""
                    We are unable to update the map at this time.
                    Please try again later. Goodbye.""");
            System.exit(1);
            return false;
        }
    }

    public int humanNorth(Human human) {
        human.setPosition(human.getPosition() - 4);
        return human.getPosition();
    }

    public int humanSouth(Human human) {
        human.setPosition(human.getPosition() + 4);
        return human.getPosition();
    }

    public int humanEast(Human human) {
        human.setPosition(human.getPosition() + 1);
        return human.getPosition();
    }

    public int humanWest(Human human) {
        human.setPosition(human.getPosition() - 1);
        return human.getPosition();
    }

    public int goblinNorth(Goblin goblin) {
        goblin.setPosition(goblin.getPosition() - 4);
        return goblin.getPosition();
    }

    public int goblinSouth(Goblin goblin) {
        goblin.setPosition(goblin.getPosition() + 4);
        return goblin.getPosition();
    }

    public int goblinEast(Goblin goblin) {
        goblin.setPosition(goblin.getPosition() + 1);
        return goblin.getPosition();
    }

    public int goblinWest(Goblin goblin) {
        goblin.setPosition(goblin.getPosition() - 1);
        return goblin.getPosition();
    }

    public void humanCombat(Human human, Goblin goblin) {
        if (human.getPosition() == goblin.getPosition()){
                human.attackGoblin(goblin);
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                    + "\nAFTERMATH OF THE BRAWL:" +
                        "\nHuman health: " + human.getHealth() +
                        "\nGoblin health: " + goblin.getHealth());
        }
    }

    public void goblinCombat(Goblin goblin, Human human) {
        if (human.getPosition() == goblin.getPosition()){
                goblin.attackHuman(human);
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                        + "\nAFTERMATH OF THE BRAWL:" +
                        "\nGoblin health: " + goblin.getHealth() +
                        "\nHuman health: " + human.getHealth());
        }
    }

    public void resetMap(String blanks, Human h, Goblin g){
        for(int i = 0; i < 16; i++) {
            gridArrayList.set(i, blanks);
        }
        gridArrayList.set(0, h);
        gridArrayList.set(15, g);
    }

    public void checkForWin(int humanHealth, int goblinHealth) {
        if (humanHealth <= 0) {
            System.out.println("""
                    It looks as though THE GOBLIN HAS WON!!
                    Thank you for playing 'Humans vs. Goblins!' 
                    We hope to see you again soon ╰(*°▽°*)╯""");
            System.exit(0);
        }

        if (goblinHealth <= 0) {
            System.out.println("""
                    It looks as though THE HUMAN HAS WON!!
                    Thank you for playing 'Humans vs. Goblins!' 
                    We hope to see you again soon ╰(*°▽°*)╯""");
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        byte[] landByteArr = "In the Land of Death...".getBytes(StandardCharsets.UTF_8);

        return new String(landByteArr, StandardCharsets.UTF_8);
    }
}
