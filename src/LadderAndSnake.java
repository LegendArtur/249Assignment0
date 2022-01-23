// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 1
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------


import java.util.Random;

public class LadderAndSnake {

    private int numberOfPlayers;
    private int[][] board;

    private String[][] playerList;

    public LadderAndSnake() {
        board = new int[10][10];
    }

    public LadderAndSnake(int players) {
        this();
        this.setNumberOfPlayers(players);
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int flipDice() {
        Random random = new Random();
        return random.nextInt(1, 7);
    }

    public void play() {

    }

    public void determinePlayerOrder() {

    }


}
