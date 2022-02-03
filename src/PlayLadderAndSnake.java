// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 2
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------

import java.util.Scanner;

public class PlayLadderAndSnake {

    static Scanner keyboard = new Scanner(System.in);

    static final int maxPlayers = 4; //This integer controls the max amount of Players.
    //change the 4 to any number to test sorting algorithm.

    public static void main(String[] args) {

        System.out.println("--------------------------------------------------------------\nWelcome to Ladder and Snake Java program by Artur Gubaidullin\n--------------------------------------------------------------");

        int playerCount = 0;
        int attempts = 0;

        System.out.print("Please input the number of players (between 2 and "+maxPlayers+" inclusively): ");
        do {
            if (keyboard.hasNextInt()){
                playerCount = keyboard.nextInt();
                if (playerCount < 2 || playerCount > maxPlayers) {
                    attempts += 1;
                    System.out.print("--- The value is not between 2 and "+maxPlayers+"! You have "+(4-attempts)+" attempt(s) left.");
                    if (attempts < 4) {
                        System.out.print("\nPlease try again: ");
                    }
                }
            } else {
                attempts += 1;

                System.out.println("The value entered is not a number!");
                if (attempts < 4) {
                    System.out.print("\nPlease try again: ");
                }
                keyboard.next();
            }

        } while ((playerCount < 2 || playerCount > maxPlayers) && attempts < 4);
        if (attempts == 4) {
            System.out.println("\n--------------------------------------------------\nSorry! You ran out of attempts to input a valid number of players.\nProgram terminating...");
            System.exit(0);
        }

        LadderAndSnake game = new LadderAndSnake(playerCount);
        game.play();



    }


}
