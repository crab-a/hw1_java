import java.lang.annotation.Documented;

public class Player {
    /**
     *     this class is for each player in the game. each player has name and 2 decks.
     */
    private final String name;
    public Deck playDeck;
    public Deck winDeck;

    public Player(String name) {
        /**
         * constructs the object player with name, play deck and win deck
         * @param: name: the name of the player
         */
        this.name = name;
        this.playDeck = new Deck(false);
        this.winDeck = new Deck(false);
    }
    public String getName(){
        /**
         * returns the name of the player
         */
        return this.name;
    }
    public void addPlayDeck(Card card) {
        /**
         * this method gets a card and add it to the 'play deck' of the player
         * @param: card: the card to add
         */
        this.playDeck.addCard(card);
    }

    public void addWinDeck(Card card) {
        /**
         * this method gets a card and add it to the 'win deck' of the player
         */
        this.winDeck.addCard(card);
    }

    public Card drawCard() {
        /**
         * this method remove a card from the play deck and returns its value
         */
        return this.playDeck.removeTopCard();
    }

    public boolean outOfCards() {
        /**
         * this method returns if the player is out of cards or not
         */
        return (this.playDeck.isEmpty() && this.winDeck.isEmpty());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
