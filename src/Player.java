// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 1 (extra class)
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------

/**
 * Player class. It simulates a real life player.
 * @author Artur Gubaidullin
 * @see <P>COMP249
 * <P>Assignment #1
 * <P>Due Date 07/02/2022
 */
public class Player {

    private String name;
    private int position;
    private int diceThrow;

    /**
     * Default constructor. Players start on position 0 by default.
     */
    public Player() {
        position = 0;
    }

    /**
     * Player constructor with given name.
     * @param name wanted name for player.
     */
    public Player(String name) {
        this();
        this.name = name;

    }

    /**
     * Sets position to given integer.
     * @param position new position of the player.
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Returns current position.
     * @return position of Player
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets name to Player.
     * @param name Player name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns player's name.
     * @return Player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns players current die throw.
     * @return Player's dice value
     */
    public int getDiceThrow() {
        return diceThrow;
    }

    /**
     * Sets Players last dice throw to given integer.
     * @param diceThrow Value of the dice.
     */
    public void setDiceThrow(int diceThrow) {
        this.diceThrow = diceThrow;
    }
}
