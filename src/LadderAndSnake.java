// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 1
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------

//When a game is created, the specified number of Player objects is created.
//Each player then throws a die, to determine their play order.
//The highest player plays first and lowest last.

/**
 * Artur Gubaidullin
 * COMP249
 * Assignment #1
 * Due Date 07/02/2022
 */

//importing Scanner for input and Random for dice throwing
import java.util.Random;
import java.util.Scanner;

public class LadderAndSnake {


    private final Scanner keyboard = new Scanner(System.in);

    //Board stores all our snakes and ladders, as well as player movement.
    private Board board = new Board();

    //List of players.
    private Player[] playerList;

    //Default constructor
    public LadderAndSnake() {
    }

    //Constructor with specified number of players
    public LadderAndSnake(int playerCount) {
        this();

        playerList = new Player[playerCount];
        initialisePlayers();
        namePlayers();
    }

    //Creates the necessary amount of players.
    private void initialisePlayers() {
        for (int i = 0; i < playerList.length; i++) {
            playerList[i] = new Player("Player #" + i);
        }
    }

    //Checks if the user wants names, and in case they do, names the players one by one.
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
                System.out.println("Please put name for " + player.getName());
                player.setName(keyboard.next() + keyboard.nextLine());
            }
        } else {
            System.out.println("No names will be assigned.");
        }
    }

    //Returns a values between 1 and 6 inclusively.
    public int flipDice() {
        Random random = new Random();
        return random.nextInt(1, 7);
    }

    //The actual gameplay, with order determination, rules, snakes, ladders, and a winner!
    public void play() {

        //Determines the order in which players are going to play
        determinePlayerOrder(playerList);
        if (hasDuplicates(playerList)){
            fixDuplicates(playerList);
        }

        //Final player order message
        System.out.println("--------------------- Final order of players --------------------");
        for (Player player : playerList) {
            System.out.print(player.getName() + " ");
        }

        System.out.println("\n--------------------- The game is starting! ---------------------");

        //Game is player in previously determined order
        boolean gameNotDone = true;
        while (gameNotDone) {
            for (Player player : playerList) {
                board.move(flipDice(), player);

                if (player.getPosition() == 100) {

                    System.out.println("The game is over! " + player.getName() + " won the game !!!");
                    gameNotDone = false;
                    break;
                }
            }
        }
    }

    //Checks if there are any duplicates in given Player array.
    private boolean hasDuplicates(Player[] playerList) {

        for (int i = 0; i < playerList.length-1; i++) {
            if (playerList[i].getDiceThrow() == playerList[i+1].getDiceThrow()) {
                return true;
            }
        }
        return false;
    }

    //Determines the order of player by dice throw.
    private void determinePlayerOrder(Player[] playerList) {
        int[] playerValues = new int[playerList.length];

        //Each player throws the dice
        for (int i = 0; i < playerList.length; i++) {
            playerList[i].setDiceThrow(flipDice());
            playerValues[i] = playerList[i].getDiceThrow();
            System.out.println(playerList[i].getName() + " flipped the dice and got: " + playerValues[i]);
        }

        //Players are then sorted from highest to smallest value.
        int temp; int counter; Player tempPlayer;
        for (int i = 0; i < playerValues.length; i++) {
            counter = 0;
            while (counter < playerValues.length-1) {
                if (playerValues[counter] < playerValues[counter + 1]) {
                    temp = playerValues[counter + 1];
                    playerValues[counter + 1] = playerValues[counter];
                    playerValues[counter] = temp;

                    //The same permutations that are done on the dice values array are done on the Player array.
                    // (therefore players are also sorted descending)
                    tempPlayer = playerList[counter + 1];
                    playerList[counter + 1] = playerList[counter];
                    playerList[counter] = tempPlayer;
                }
                counter++;
            }
        }
    }

    //All duplicate throws (Players with same dice values) play again.
    private void fixDuplicates(Player[] playerList) {
        Duplicate[] duplicates = new Duplicate[] {};

        //given player list is split up by dice values.
        for (int i = 0; i < playerList.length; i++) {
            duplicates = addDuplicate(duplicates, playerList[i], i);
        }

        //Only those that are duplicates rethrow their dice.
        for (Duplicate duplicate : duplicates) {
            if (duplicate.getPlayers().length > 1) {
                Player[] playersToChange = duplicate.getPlayers();

                System.out.print("---------------------\nPlayers ");
                for (Player player : playersToChange) {
                    System.out.print(player.getName() + " ");
                }
                System.out.println("got the same number! They play again:");

                //These players play again and are sorted
                determinePlayerOrder(playersToChange);

                //The players that had the same value, and now have replayed their dice, could again have draws.
                if (hasDuplicates(playersToChange)) {
                    //recursive method, that will fix duplicates only of players that replayed the game.
                    fixDuplicates(playersToChange);
                }

                //They are then put back into the Player list.
                for (int i = 0; i < playersToChange.length; i++){
                    playerList[i + duplicate.getOriginalOrder()] = playersToChange[i];
                }
            }
        }
    }

    //This adds a player their respective Duplicate (dice value wise)
    //Or, if their value is not yet saved, creates a new Duplicate.
    private Duplicate[] addDuplicate(Duplicate[] duplicates, Player player, int originalOrder) {

        boolean exists = false;
        for (Duplicate duplicate : duplicates) {
            if (duplicate.getDiceValue() == player.getDiceThrow()){
                exists = true;
                duplicate.addPlayer(player);
                break;
            }
        }

        if (!exists) {
            Duplicate[] newDuplicates = new Duplicate[duplicates.length+1];
            for (int i = 0; i < duplicates.length; i++) {
                newDuplicates[i] = duplicates[i];
            }

            newDuplicates[duplicates.length] = new Duplicate(player, originalOrder) {};

            return newDuplicates;
        } else {
            return duplicates;
        }
    }
}
