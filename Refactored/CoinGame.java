public class CoinGame extends GameMode {

    private int headsCount = 0;
    private int tailsCount = 0;
    private Coin coin;

    public void initialiseGame() throws Exception {
        coin = new Coin();
    }

    public void mainGame() throws Exception {
        // The main game:
        // Let user flip the coin 4 times
        for (int i = 0; i < 4; i++) {
            System.out.println("Hit <RETURN> to flip the coin");
            Reader.reader.readLine();
            String coinState = coin.flip();
            if (coinState == "Head") {
                headsCount++;
            } else {
                tailsCount++;
            }
            // Display the result of flipping the coin
            System.out.println("Your coin landed with " + coinState + " facing up");
        }
    }

    public void declareGameWinner() throws Exception {
        // If the coin landed heads up at least three times, the person won; otherwise (s)he lost
        System.out.println("You got " + headsCount + " heads and " + tailsCount + " tails");
        if (headsCount >= 3)
            System.out.println("You won, because you had three heads or more");
        else
            System.out.println("You lost, because you had fewer than three heads");
    }
}
