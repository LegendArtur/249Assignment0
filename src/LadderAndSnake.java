// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 1
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------


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
            playerList[i] = new Player("Player #" + i);
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
        int[] playerOrder = new int[playerList.length];

        //Each player throws the dice
        for (int i = 0; i < playerList.length; i++) {
            playerOrder[i] = flipDice();
            System.out.println(playerList[i].getName() + " flipped the dice and got: " + playerOrder[i]);
        }

        //Players are then sorted from highest to smallest value.
        int temp; int counter; Player tempPlayer;
        for (int i = 0; i < playerOrder.length; i++) {
            counter = 0;
            while (counter < playerOrder.length-1) {
                if (playerOrder[counter] < playerOrder[counter + 1]) {
                    temp = playerOrder[counter + 1];
                    playerOrder[counter + 1] = playerOrder[counter];
                    playerOrder[counter] = temp;

                    tempPlayer = playerList[counter + 1];
                    playerList[counter + 1] = playerList[counter];
                    playerList[counter] = tempPlayer;
                }
                counter++;
            }
        }
    }

    private void namePlayers() {
        String answer;
        System.out.println("Would you like to name your players? (yes or no): ");
        do {
            answer = keyboard.next().toLowerCase();
            if (!(answer.equals("yes") || answer.equals("no"))) {
                System.out.println("Not a valid answer (yes or no). Try again: ");
            }
        } while (!(answer.equals("yes") || answer.equals("no")));

        if (answer.equals("yes")) {
            for (Player player : playerList) {
                System.out.println("Please put name for Player #" + player.getName());
                player.setName(keyboard.next());
            }
        } else {
            System.out.println("No names will be assigned.");
        }
    }


}
