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

//This represents a real life board. This is where players move.
public class Board {

    private final int[][] snakes = new int[][] {
            new int[] {16,6},
            new int[] {48,30},
            new int[] {64,60},
            new int[] {79,19},
            new int[] {93,68},
            new int[] {95,24},
            new int[] {97,76},
            new int[] {98,78},
    };
    private final int[][] ladders = new int[][] {
            new int[] {1,38},
            new int[] {4,14},
            new int[] {9,31},
            new int[] {21,42},
            new int[] {28,84},
            new int[] {36,44},
            new int[] {51,67},
            new int[] {71,91},
            new int[] {80,100},
    };

    public Board() {}

    //Player moves by the thrown dice value. (including all snake and ladder changes)
    public void move(int diceValue, Player player) {
        int position = player.getPosition();
        String name = player.getName();

        //This checks if player went beyond 100.
        if ((position + diceValue) > 100) {
            position = 200-position-diceValue;
            System.out.println(name + " threw and got : " + diceValue + ". They went over 100 !!! They go to " + position);

        }
        //If not, plays normally.
        else {
            position += diceValue;
            System.out.println(name + " threw and got : " + diceValue + ". They move to case " + position);
        }

        //Checks if player reached a snake and moves them accordingly.
        for (int[] snake : snakes) {
            if (position == snake[0]) {
                position = snake[1];
                System.out.println("-- Oh no! This case is a snake's head! " + name + " goes down to " + snake[1]);
            }
        }

        //Checks if player reached a ladder and moves them accordingly.
        for (int[] ladder : ladders) {
            if (position == ladder[0]) {
                position = ladder[1];
                System.out.println("-- This case is a ladder! " + name + " goes up to " + ladder[1]);
            }
        }

        player.setPosition(position);

    }
}
