import java.util.*;

public class Deck {
    /**
     * container for playing cards, each deck have Cards or is empty.
     */
    List<Card> deck;
    private static final int TIMES_TO_SHUFFLE=50;
    private int lastCardIndex=0;

    public Deck(boolean makeDeck) {
        /*
         * create a deck of Cards
         * @param makeDeck if false the constructor makes an empty deck
         *                 if true build full suite of cards.
         */
        this.deck=new ArrayList<>();
        if (makeDeck) {
            for (Shape shape : Shape.values()) {
                for (Value value : Value.values()) {
                    addCard(new Card(value, shape));//change to add card
                }
            }
        }
        this.lastCardIndex--;
    }
    Card getTopCard(){
        return this.deck.get(lastCardIndex);
    }

    void addCard(Card card) {
        this.deck.add(card);
        this.lastCardIndex++;
    }

    Card removeTopCard() {
        Card topCard = this.deck.get(lastCardIndex);
        this.deck.remove(this.lastCardIndex--);
        return topCard;
    }

    boolean isEmpty() {
        return this.lastCardIndex < 0;
    }

    void shuffle() {
        for (int i = 0; i < TIMES_TO_SHUFFLE; i++) {
            int first = Main.rnd.nextInt(this.lastCardIndex+1), sec = Main.rnd.nextInt(this.lastCardIndex+1);
            Card temp = this.deck.get(first);
            this.deck.set(first, this.deck.get(sec));
            this.deck.set(sec, temp);
        }

    }
}
