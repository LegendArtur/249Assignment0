// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 1
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------


import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class LadderAndSnake {

    private Scanner keyboard = new Scanner(System.in);

    private int[][] board;

    private Player[] playerList;

    public LadderAndSnake() {
        board = new int[10][10];
    }

    public LadderAndSnake(int playerCount) {
        this();

        playerList = new Player[playerCount];
        initialisePlayers();
        namePlayers();
    }

    private void initialisePlayers() {
        for (int i = 0; i < playerList.length; i++) {
            playerList[i] = new Player(Integer.toString(i));
        }
    }

    public void setPlayerList(Player[] playerList) {
        this.playerList = playerList;
    }

    public Player[] getPlayerList() {
        return playerList;
    }

    public int flipDice() {
        Random random = new Random();
        return random.nextInt(1, 7);
    }

    public void play() {

        determinePlayerOrder();

    }


    private void determinePlayerOrder() {
        

    }

    private void namePlayers() {
        String answer;
        do {
            System.out.println("Would you like to name your players? (yes or no): ");
            answer = keyboard.next().toLowerCase();
            if (!(answer.equals("yes") || answer.equals("no"))) {
                System.out.println("Not a valid answer (yes or no). Try again: ");
            }
        } while (!(answer.equals("yes") || answer.equals("no")));

        if (answer.equals("yes")) {
            for (Player player : playerList) {
                System.out.println("Please put name for");
                player.setName(keyboard.next());
            }
        } else {
            System.out.println("No names will be assigned.");
        }
    }


}
