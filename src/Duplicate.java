// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 1 (extra class)
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------

/**
 * This class is essentially a Player array, storing all players with the same dice value.
 *     We have to remember that players going into this duplicate are already sorted out.
 * It also stores their original place in their player list:
 * If player 2, 3, 4 rethrow, it stores 2, they will be repositioned starting from 2 then 3, 4.
 *
 * @author Artur Gubaidullin
 * @see <P>COMP249
 * <P>Assignment #1
 * <P>Due Date 07/02/2022
 */
public class Duplicate {

    private Player[] players;
    private final int originalOrder;
    private final int diceValue;

    /**
     * Creates the Duplicate with the new player dice value, as well as their original position.
     * @param player Player with a dice value that was not in another Duplicate.
     * @param originalOrder Position of given player in their original array
     */
    public Duplicate(Player player, int originalOrder) {
        players = new Player[] {player};
        this.originalOrder = originalOrder;
        diceValue = player.getDiceThrow();
    }

    /**
     * Manual array copy.
     * @param player Player to be added to Duplicate's player list.
     */
    public void addPlayer(Player player) {
        Player[] newPlayers = new Player[players.length+1];

        for (int i = 0; i < players.length; i++) {
            newPlayers[i] = players[i];
        }
        newPlayers[players.length] = player;

        players = newPlayers;
    }

    /**
     * Players in Duplicate getter
     * @return players
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Original Order getter
     * @return the original position of players
     */
    public int getOriginalOrder() {
        return originalOrder;
    }

    /**
     * Dice value of Duplicate getter
     * @return dice value
     */
    public int getDiceValue() {
        return diceValue;
    }

}
