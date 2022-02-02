// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 1 (extra class)
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------


public class Duplicate {

    private Player[] players;
    private int originalOrder;
    private int diceValue;

    public Duplicate(Player player, int originalOrder) {
        players = new Player[] {player};
        this.originalOrder = originalOrder;
        diceValue = player.getDiceThrow();
    }

    public Player[] getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        Player[] newPlayers = new Player[players.length+1];

        for (int i = 0; i < players.length; i++) {
            newPlayers[i] = players[i];
        }
        newPlayers[players.length] = player;

        players = newPlayers;
    }

    public int getOriginalOrder() {
        return originalOrder;
    }

    public int getDiceValue() {
        return diceValue;
    }

}
