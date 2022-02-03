// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 1 (extra class)
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------


public class Player {

    private String name;
    private int position;
    private int diceThrow;

    public Player() {
        position = 0;
    }

    public Player(String name) {
        this();
        this.name = name;

    }

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
