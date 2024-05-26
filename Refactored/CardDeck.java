import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CardDeck {
    private final ArrayList<Card> cardList = new ArrayList<>();
    private final String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private final String[] suits = {"Hrts", "Dmnds", "Spds", "Clbs"};

    public void initialiseDeck() {
        for (String suit : suits) {
            for (String rank : ranks) {
                Card c = new Card(rank, suit);
                this.cardList.add(c);
            }
        }
    }

    public String displayDeck() {
        String[] tempList = new String[cardList.size()];
        for (int i = 0; i < cardList.size(); i++) {
            tempList[i] = cardList.get(i).suit() + cardList.get(i).rank();
        }
        return Arrays.toString(tempList);
    }

    public void shuffleDeck() {
        Collections.shuffle(cardList);


    }

    public int getRandomCardIndex() {
        return (int) (Math.random() * cardList.size());
    }

    public void removeCard(int index) {
        cardList.remove(index);
    }

    public String getCardString(int i) {
        return cardList.get(i).convertToString();
    }

    public Card getCard(int x) {
        return cardList.get(x);
    }

}
