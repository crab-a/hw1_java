public class Player {
    private String name;
    public Deck playDeck;
    public Deck winDeck;

    public Player(String name) {
        this.name = name;
        this.playDeck = new Deck(false);
        this.winDeck = new Deck(false);
    }

    public void addPlayDeck(Card card) {
        this.playDeck.addCard(card);
    }

    public void addWinDeck(Card card) {
        this.winDeck.addCard(card);
    }

    public Card drawCard() {
        return this.playDeck.removeTopCard();
    }

    public boolean outOfCards() {
        return (this.playDeck.isEmpty() && this.winDeck.isEmpty());
    }

    public String toString() {
        return this.name;
    }
}
