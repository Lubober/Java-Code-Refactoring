public class Game {
    public static void main(String[] args) throws Exception {
        try {
            System.out.print("Card (c), Die (d) or Coin-Flipping (f) game? ");
            String ans = Reader.reader.readLine();
            GameModes.chooseGameMode(ans);
        } catch (Exception e) {
            System.out.println("internal error, try again");
        }
    }

}
