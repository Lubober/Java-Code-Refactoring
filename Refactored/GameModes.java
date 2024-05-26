public class GameModes {
    public static void chooseGameMode(String ans) throws Exception {
        switch (ans) {
            case "c" -> {
                GameMode c = new CardGame();
                c.playGame();
            }
            case "d" -> {
                GameMode d = new DieGame();
                d.playGame();
            }
            case "f" -> {
                GameMode f = new CoinGame();
                f.playGame();
            }
            default -> System.out.println("Input not understood");
        }
    }


}
