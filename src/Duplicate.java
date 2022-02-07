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

//This class is essentially a Player array, storing all players with the same dice value.
    //We have to remember that players going into this duplicate are already sorted out.
//It also stores their original place in their player list:
// If player 2, 3, 4 rethrow, it stores 2, they will be repositioned starting from 2 then 3, 4.

public class Duplicate {

    private Player[] players;
    private final int originalOrder;
    private final int diceValue;

    //Creates the Duplicate with the new player dice value, as well as their original position.
    public Duplicate(Player player, int originalOrder) {
        players = new Player[] {player};
        this.originalOrder = originalOrder;
        diceValue = player.getDiceThrow();
    }

    //Manual array copy.
    public void addPlayer(Player player) {
        Player[] newPlayers = new Player[players.length+1];

        for (int i = 0; i < players.length; i++) {
            newPlayers[i] = players[i];
        }
        newPlayers[players.length] = player;

        players = newPlayers;
    }

    //Getter methods
    public Player[] getPlayers() {
        return players;
    }

    public int getOriginalOrder() {
        return originalOrder;
    }

    public int getDiceValue() {
        return diceValue;
    }

}
