import java.util.ArrayList;

public class DieGame extends GameMode {
    private final ArrayList<Integer> numbersRolled = new ArrayList<>();
    private Die die;

    public void initialiseGame() {
        die = new Die();
    }

    public void mainGame() throws Exception {
        // The main game
        // Let the user roll the die twice
        for (int i = 0; i < 2; i++) {
            System.out.println("Hit <RETURN> to roll the die");
            Reader.reader.readLine();
            die.roll();
            int dieRoll = die.getNumber();
            System.out.println("You rolled " + dieRoll);
            numbersRolled.add(dieRoll);
        }
        // Display the numbers rolled
        System.out.println("Numbers rolled: " + numbersRolled);
    }

    public void declareGameWinner() throws Exception {
        // Declare the winner:
        // User wins if at least one of the die rolls is a 1
        if (numbersRolled.contains(1)) {
            System.out.println("You won!");
        } else System.out.println("You lost!");
    }
}
