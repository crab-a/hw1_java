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
        }
        else{ this.lastCardIndex=-1; }
    }
    void addCard(Card card){
        this.deck.add(card);
        this.lastCardIndex++;
    }

    Card removeTopCard(){
        Card topCard = this.deck.get(lastCardIndex);
        this.deck.remove(this.lastCardIndex--);
        return  topCard;
    }

    boolean isEmpty(){ return this.lastCardIndex<0; }

    void shuffle(){
        for(int i=0; i<50; i++){
            int first = Main.rnd.nextInt(), sec=Main.rnd.nextInt();
            Card temp =this.deck.get(first);
            this.deck.set(first,this.deck.get(sec));
            this.deck.set(sec,temp);
        }

    }
}
