import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CardGame extends GameMode {
    private final ArrayList<Card> cardsChosen = new ArrayList<>();
    private final CardDeck deck = new CardDeck();

    public void initialiseGame() {

        deck.initialiseDeck();
        deck.shuffleDeck();
        System.out.println(deck.displayDeck());
    }

    public void mainGame() throws IOException {
        for (int i = 0; i < 2; i++) {
            System.out.println("Hit <RETURN> to choose a card");
            Reader.reader.readLine();
            int cardIndex = deck.getRandomCardIndex();
            System.out.println("You chose " + deck.getCardString(cardIndex));
            cardsChosen.add(deck.getCard(cardIndex));
            deck.removeCard(cardIndex);
        }
        // Display the cards chosen and remaining cards
        System.out.println("Cards chosen: " + Arrays.toString(cardsChosen.stream().map(Card::convertToString).toArray()));
        System.out.println("Remaining cards: " + deck.displayDeck());
    }

    public void declareGameWinner() throws Exception {
        // Declare the winner:
        System.out.println("Cards chosen: " + Arrays.toString(cardsChosen.stream().map(Card::convertToString).toArray()));
        // User wins if one of them is an Ace
        ArrayList<String> suitsChosen = new ArrayList<>();
        for (Card card : cardsChosen) {
            suitsChosen.add(card.suit());
        }
        if (suitsChosen.contains("A")) {
            System.out.println("You won!");
        } else System.out.println("You lost!");
    }


}
