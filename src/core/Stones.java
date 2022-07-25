package core;

public class Stones {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.name") + ", good luck !!!");
        new Stones();
    }


    private UserInterface userInterface;

    private static Stones instance;

    private Stones() {
        instance = this;
        userInterface = new UserInterface() {
            @Override
            public void newGame(Field field) {

            }

            @Override
            public void update() {

            }
        };
        Field field = new Field(4, 4);                     //ps set field parameters, could be changed by level option later
        userInterface.newGame(field);

    }

    public static Stones getInstance() {
        if (instance == null) {
            return (new Stones());
        }
        return instance;
    }

}
