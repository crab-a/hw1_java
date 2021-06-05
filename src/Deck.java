import java.util.*;

public class Deck {
    public List<Card> deck;
    private int lastCardIndex;
    public Deck(boolean makeDeck){
        if(makeDeck) {
            for (Shape shape : Shape.values()) {
                for (Value value : Value.values()) {
                    addCard(new Card(value, shape));//change to add card
                }
            }
            this.lastCardIndex=this.deck.size()-1;
        }
    }
    void addCard(Card card){ deck.add(card); }

    Card removeTopCard(){
        Card topCard = this.deck.get(deck.size()-1);
        this.deck.remove(this.lastCardIndex--);
        return  topCard;
    }

    boolean isEmpty(){ return this.lastCardIndex!=0; }

    void shuffle(){

    }
}
