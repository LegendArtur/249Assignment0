// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 2
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------

import java.util.Scanner;

public class PlayLadderAndSnake {

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("--------------------------------------------------------------\nWelcome to Ladder and Snake Java program by Artur Gubaidullin\n--------------------------------------------------------------");

        System.out.print("Please in put the number of players (between 2 and 4 inclusively): ");
        int playerCount = 0;
        do {
            if (keyboard.hasNextInt()){
                playerCount = keyboard.nextInt();
                if (playerCount < 2 || playerCount > 4) {
                    System.out.print("The value is not between 2 and 4, please try again: ");
                }
            } else {
                System.out.println("The value entered is not a number! Try again: ");
                keyboard.next();
            }
        } while (playerCount < 2 || playerCount > 4);

        LadderAndSnake game = new LadderAndSnake(playerCount);

        game.play();

    }


}
