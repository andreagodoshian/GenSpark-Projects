/* 1. Everything must be objects
(land, goblins, humans)
--check--

2. override toString method
(to represent each of the object)
--check--

3. create a grid for the game world
--check, i guess--

4. use UTF characters
(for human, goblin, and land)
--check--

5. game is turn-based move
(n/s/e/w)
--check--

6. if human & goblin collide - combat initiated
--im going to pretend this is like chess
& being "next" to each other doesn't count--

7. Combat uses Math.random
--check--

8. Extras (not mandatory - see assignment for details) */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String rawInput;
        char charHuman;
        char charGoblin;
        String emptySpace = " _____ ";

        Land land = new Land(emptySpace);
        Human human = new Human(0,25,100);
        Goblin goblin = new Goblin(15,35,75);

        land.gridArrayList.set(0, human);
        land.gridArrayList.set(15, goblin);

        System.out.println("""
                Welcome to 'Humans vs. Goblins!'
                A self-explanatory game, for two players.
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n""");

        land.dramaticEffect();
        System.out.println(land);
        land.printMap(land.gridArrayList);
        land.dramaticEffect();

        System.out.println("""
                \n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                Ready to play? Press enter (or q to quit)""");

        try{
            rawInput = input.nextLine().toLowerCase();
            char quitImmediately = rawInput.charAt(0);
            if (quitImmediately == 'q'){
                System.out.println("До свидания!");
                System.exit(0);
            }
        } catch (Exception e){
            // just in case lol
        }

        System.out.println("LET'S GET READY TO RUMBLEEEEEEEEEEEEEEEEEEEEEE!");
        land.dramaticEffect();

        /////////////////////////////////////////////////////////////
        // the actual game loop
        /////////////////////////////////////////////////////////////

        while(true){

            System.out.println("""
                    \n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    Human's turn: enter N, S, E, or W below... (or q to quit)""");

            try{
                rawInput = input.nextLine().toLowerCase();
                charHuman = rawInput.charAt(0);
            } catch (Exception e){
                charHuman = 'x';
            }

            // "In the Land of Death..."
            System.out.println(land);
            land.dramaticEffect();
            try{
                switch (charHuman) {
                    case 'n': {
                        land.gridArrayList.set(land.humanNorth(human), human);
                        land.gridArrayList.set(land.gridArrayList.lastIndexOf(human), emptySpace);
                        break;
                    }
                    case 's': {
                        land.gridArrayList.set(land.humanSouth(human), human);
                        land.gridArrayList.set(land.gridArrayList.indexOf(human), emptySpace);
                        break;
                    }
                    case 'e': {
                        land.gridArrayList.set(land.humanEast(human), human);
                        land.gridArrayList.set(land.gridArrayList.indexOf(human), emptySpace);
                        break;
                    }
                    case 'w': {
                        land.gridArrayList.set(land.humanWest(human), human);
                        land.gridArrayList.set(land.gridArrayList.lastIndexOf(human), emptySpace);
                        break;
                    }
                    case 'q':{
                        System.out.println("It seems as though you have decided to quit. Goodbye.");
                        System.exit(0);
                    }
                    default: {
                        System.out.println("It seems as though you have forfeited your turn.\n");
                        break;
                    }
                }
            } catch (Exception e){
                System.out.println("""
                        The human has gone out of bounds, and is therefore disqualified.
                        Good game? До свидания!""");
                System.exit(0);
            }

            land.printMap(land.gridArrayList);
            land.humanCombat(human, goblin);
            land.dramaticEffect();
            land.checkForWin(human.getHealth(), goblin.getHealth());

            if (human.getPosition() == goblin.getPosition()){
                human.setPosition(0);
                goblin.setPosition(15);

                land.dramaticEffect();
                land.resetMap(emptySpace, human, goblin);
                land.printMap(land.gridArrayList);
            }

            /////////////////////////////////////////////////////////////

            System.out.println("""
                    \n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    Goblin's turn: enter N, S, E, or W below... (or q to quit)""");

            try{
                rawInput = input.nextLine().toLowerCase();
                charGoblin = rawInput.charAt(0);
            } catch (Exception e){
                charGoblin = 'x';
            }

            // "In the Land of Death..."
            System.out.println(land);
            land.dramaticEffect();
            try{
                switch (charGoblin) {
                    case 'n': {
                        land.gridArrayList.set(land.goblinNorth(goblin), goblin);
                        land.gridArrayList.set(land.gridArrayList.lastIndexOf(goblin), emptySpace);
                        break;
                    }
                    case 's': {
                        land.gridArrayList.set(land.goblinSouth(goblin), goblin);
                        land.gridArrayList.set(land.gridArrayList.lastIndexOf(goblin), emptySpace);
                        break;
                    }
                    case 'e': {
                        land.gridArrayList.set(land.goblinEast(goblin), goblin);
                        land.gridArrayList.set(land.gridArrayList.lastIndexOf(goblin), emptySpace);
                        break;
                    }
                    case 'w': {
                        land.gridArrayList.set(land.goblinWest(goblin), goblin);
                        land.gridArrayList.set(land.gridArrayList.lastIndexOf(goblin), emptySpace);
                        break;
                    }
                    case 'q':{
                        System.out.println("It seems as though you have decided to quit. Goodbye.");
                        System.exit(0);
                    }
                    default: {
                        System.out.println("It seems as though you have forfeited your turn.\n");
                        break;
                    }
                }
            } catch (Exception e){
                System.out.println("""
                        The goblin has gone out of bounds, and is therefore disqualified.
                        Good game? До свидания!""");
                System.exit(0);
            }

            land.printMap(land.gridArrayList);
            land.goblinCombat(goblin, human);
            land.dramaticEffect();
            land.checkForWin(human.getHealth(), goblin.getHealth());

            if (goblin.getPosition() == human.getPosition()){
                human.setPosition(0);
                goblin.setPosition(15);

                land.dramaticEffect();
                land.resetMap(emptySpace, human, goblin);
                land.printMap(land.gridArrayList);
            }
        }
    }
}