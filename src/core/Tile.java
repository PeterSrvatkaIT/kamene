package core;

public class Tile {
    public Tile(int counter, int row, int column) {

    }

    public int getValue() {
        return value;
    }

    private int value;


    @Override
    public String toString() {
        if (value == 0) {
            return "#";
        } else {
            return String.valueOf(value);
        }

    }

}
