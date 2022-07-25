package consoleUI;

import core.Field;
import core.GameState;
import core.UserInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ConsoleUI {

    public abstract class ConsoleUIclass implements UserInterface {
        private Field field;
        private final ArrayList<String> listOfCommands = new ArrayList<String>(
                Arrays.asList("n", "e", "w", "s", "a", "d", "u", "d", "l", "r"));   //possible actions


        private final BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); //ps need to integrate


        @Override
        public void newGame(Field field) {
            this.field = field;
            do {
                update();
                if (field.getGamestate() == GameState.SOLVED) {
                    System.out.println("winner");
                    break;
                }
                if (field.getGamestate() == GameState.EXIT) {
                    System.out.println("loser");
                    break;
                }
            } while (true);
            //System.exit(0);
        }

        public void errorHandler(String playerInput) throws WrongFormatException {

            if (!listOfCommands.contains(playerInput)) {
                throw new WrongFormatException("error input");

            }
        }

        private void printField() {
            for (int x = 0; x < field.getColumn(); x++) {
                for (int y = 0; y < field.getRow(); y++) {
                    System.out.println(field.getTile(x, y).toString());
                }
            }
        }

        @Override
        public void update() {
            System.out.println("Options:  (n) -new game   (e) - exit  (w) - up  (s) - down  (a) - left  (d) - right");
            printField();
        }
    }
}
