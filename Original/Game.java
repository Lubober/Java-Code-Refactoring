import java.io.*;
import java.util.*;
import java.lang.Math;

public class Game {
  // The BufferedReader used throughout
  public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

  // Variable(s) used in the coin flipper methods
  public static String coinState;
  public static int headsCount;
  public static int tailsCount;
  
  public static void playCoinGame() throws Exception {
      // Play coin game:
      
      // Initialise the game
      initialiseCoinGame();
      
      // Play the main game phase
      mainCoinGame();
      
      // Now see if (s)he has won!
      declareCoinGameWinner();
  }
  
  public static void initialiseCoinGame() throws Exception {
      coinState="Tail";
      headsCount=0;
      tailsCount=0;
  }
  
  public static void mainCoinGame() throws Exception {
      // The main game:

      // Let user flip the coin 4 times
      for (int i=0; i<4; i++) {
        System.out.println("Hit <RETURN> to flip the coin");
        br.readLine();

        if (Math.random()>=0.5) {
          coinState="Head";
          headsCount++;
        }
        else {
          coinState="Tail";
          tailsCount++;
        }

        // Display the result of flipping the coin
        
        System.out.println("Your coin landed with " + coinState + " facing up");
      }
  }
  
  public static void declareCoinGameWinner() throws Exception {
      // If the coin landed heads up at least three times, the person won; otherwise (s)he lost
      System.out.println("You got " + headsCount + " heads and " + tailsCount + " tails");
      if (headsCount >= 3)
        System.out.println("You won, because you had three heads or more");
      else
        System.out.println("You lost, because you had fewer than three heads");
  }

  // Variable(s) used in the card game methods
  public static ArrayList<String> cardList;
  public static HashSet<String> cardsChosen=new HashSet<String>();

  public static void playCardGame() throws Exception {
      // Play card game:

      // Initialise the game
      initialiseCardGame();

      // Play the main game phase
      mainCardGame();

      // Now see if (s)he has won!
      declareCardGameWinner();
  }

  public static void initialiseCardGame() throws Exception {
      // The initialisation phase:

      // Create a list of cards ... and shuffle them
      String cards[]={"AHrts", "2Hrts", "3Hrts", "4Hrts", "5Hrts", "6Hrts",
                      "7Hrts", "8Hrts", "9Hrts", "10Hrts", "JHrts",
                      "QHrts", "KHrts",
                      "ADmnds", "2Dmnds", "3Dmnds", "4Dmnds", "5Dmnds",
                      "6Dmnds", "7Dmnds", "8Dmnds", "9Dmnds", "10Dmnds",
                      "JDmnds", "QDmnds", "KDmnds",
                      "ASpds", "2Spds", "3Spds", "4Spds", "5Spds", "6Spds",
                      "7Spds", "8Spds", "9Spds", "10Spds", "JSpds",
                      "QSpds", "KSpds",
                      "AClbs", "2Clbs", "3Clbs", "4Clbs", "5Clbs", "6Clbs",
                      "7Clbs", "8Clbs", "9Clbs", "10Clbs", "JClbs",
                      "QClbs", "KClbs"};
      cardList=new ArrayList<String> (Arrays.asList(cards));
      // Taking advantage of "generics" to tell the compiler all the elements will be Strings

      // Shuffle them
      for (int i=0; i<100; i++) {
        // choose two random cards at random and swap them, 100 times
        int firstIndex=((int) (Math.random() * 52));
        int secondIndex=((int) (Math.random() * 52));
        String temp=(String) cardList.get(firstIndex);
        cardList.set(firstIndex, cardList.get(secondIndex));
        cardList.set(secondIndex, temp); 
      }

      // Print out the result
      System.out.println(cardList);
  }

  public static void mainCardGame() throws Exception {
      // The main game:

      // Let user select two cards from the pack
      for (int i=0; i<2; i++) {
        System.out.println("Hit <RETURN> to choose a card");
        br.readLine();

        int cardChoice=(int) (Math.random() * cardList.size());
        System.out.println("You chose " + cardList.get(cardChoice));
        cardsChosen.add(cardList.remove(cardChoice));
      }

      // Display the cards chosen and remaining cards
      System.out.println("Cards chosen: " + cardsChosen);
      System.out.println("Remaining cards: " + cardList);

  }

  public static void declareCardGameWinner() throws Exception {
      // Declare the winner:

      // User wins if one of them is an Ace 
      System.out.println("Cards chosen: " + cardsChosen);
      if (cardsChosen.contains("AHrts") || cardsChosen.contains("ADmnds") ||
          cardsChosen.contains("ASpds") || cardsChosen.contains("AClbs")) {
        System.out.println("You won!");
      }
      else System.out.println("You lost!");
  }

//Variable(s) used in the die game methods
  public static HashSet<Integer> numbersRolled=new HashSet<Integer>();

  public static void playDieGame() throws Exception {
      // Play die game:

      // Initialise the game
      initialiseDieGame();

      // Play the main game phase
      mainDieGame();

      // Now see if (s)he has won!
      declareDieGameWinner();
  }

  public static void initialiseDieGame() throws Exception {
      // The initialisation phase:

      // Actually there isn't anything to do here
  }

  public static void mainDieGame() throws Exception {
      // The main game:

      // Let the user roll the die twice
      for (int i=0; i<2; i++) {
        System.out.println("Hit <RETURN> to roll the die");
        br.readLine();
        int dieRoll=(int)(Math.random() * 6) + 1;

        System.out.println("You rolled " + dieRoll);
        numbersRolled.add(Integer.valueOf(dieRoll));
      }

      // Display the numbers rolled
      System.out.println("Numbers rolled: " + numbersRolled);
  }

  public static void declareDieGameWinner() throws Exception {
      // Declare the winner:

      // User wins if at least one of the die rolls is a 1
      if (numbersRolled.contains(Integer.valueOf(1))) {
        System.out.println("You won!");
      }
      else System.out.println("You lost!");
  }

  public static void main(String[] args) throws Exception {
    // Ask whether to play a card game or a die game

    System.out.print("Card (c), Die (d) or Coin-Flipping (f) game? ");
    String ans=br.readLine();

    if (ans.equals("c")) {
      playCardGame();
    }

    else if (ans.equals("d")) {
      playDieGame();
    }
    
    else if (ans.equals("f")) {
      playCoinGame();
    }

    else System.out.println("Input not understood");
  }
}

