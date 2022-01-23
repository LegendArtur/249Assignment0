// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 1 and 2 (extra class)
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------


public class Player {

    private String name;
    private int position;

    public Player() {
        position = 0;
    }

    public Player(String name) {
        this();
        this.name = name;
    }

    public void addPosition(int moves) {
        position += moves;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
