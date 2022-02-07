// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 1 (extra class)
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------

/**
 * Artur Gubaidullin
 * COMP249
 * Assignment #1
 * Due Date 07/02/2022
 */

//Player class. It simulates a real life player.
public class Player {

    private String name;
    private int position;
    private int diceThrow;

    //Players start on position 0 by default.
    public Player() {
        position = 0;
    }


    public Player(String name) {
        this();
        this.name = name;

    }

    //Getters and setters
    public void setPosition(int position) {
        this.position = position;
    }
    public int getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getDiceThrow() {
        return diceThrow;
    }
    public void setDiceThrow(int diceThrow) {
        this.diceThrow = diceThrow;
    }
}
