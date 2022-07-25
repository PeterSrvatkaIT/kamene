package core;

public class Field {
    int row, column, cleanColumn, cleanRow;
    GameState gameState = GameState.PLAYING;
    Tile[][] tiles;
    private boolean gamestate;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Field(int row, int column) {
        this.row = row;
        this.column = column;
        tiles = new Tile[row][column];
    }

    public void generateTileField() {
        int counter = 1;
        for (int xAxis = 0; xAxis < this.getRow(); xAxis++) {
            for (int yAxis = 0; yAxis < this.getColumn(); yAxis++) {
                tiles[xAxis][yAxis] = new Tile(counter, getRow(), getColumn());
                counter++;
            }
        }
    }

    public Object getTile(int i, int j) {
        return true;
    }


    public boolean enableToMove(String s) {
        boolean control;
        switch (s) {

            case "d":
                control = (cleanRow + 1 >= row);
                return control;
            case "u":
                control = (cleanRow - 1 < 0);
                return control;
            case "l":
                control = (cleanColumn - 1 < 0);
                return control;
            case "r":
                control = (cleanColumn + 1 >= column);
                return control;
        }
        return true;
    }

    public GameState getGamestate() {
        return gameState;
    }

    public void setGamestate(GameState gamestate) {
        this.gameState = gamestate;
    }

    public String Up() {
        if (enableToMove("down")) {
            return "moved up";
        } else return "error";
    }

    public String Down() {
        if (enableToMove("up")) {
            return "moved down";
        } else return "error";
    }

    public String Left() {
        if (enableToMove("right")) {
            return "moved left";
        } else return "error";
    }

    public String Right() {
        if (enableToMove("left")) {
            return "moved right";
        } else return "error";
    }
}



