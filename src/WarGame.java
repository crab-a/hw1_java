public class WarGame {
    private Player player1;
    private Player player2;
    private Deck openDeckPlayer1;
    private Deck openDeckPlayer2;
    public WarGame(String nameA, String nameB){
        String firstPlayer = nameA;
        String secondPlayer = nameB;
        if(nameA.compareTo(nameB) > 0){
            firstPlayer = nameB;
            secondPlayer = nameA;
        }
        player1 = new Player(firstPlayer);
        player2 = new Player(secondPlayer);
        openDeckPlayer1 = new Deck(false);
        openDeckPlayer2 = new Deck(false);
    }
    public void initializeGame(){
        Deck initDeck = new Deck(true);
        initDeck.shuffle();
        int counter = 0;
        while (!initDeck.isEmpty()){
            Player[] playerArr = {player1, player2};
            playerArr[counter%2].addPlayDeck(initDeck.removeTopCard());
            counter++;
        }
    }
    public String start(){
        initializeGame();

    }
    public void round(){
        Card firstCard = player1.playDeck.removeTopCard();
        Card secondCard = player2.playDeck.removeTopCard();
        if(firstCard.getValue() > secondCard.getValue()){
            player1.winDeck.addCard(secondCard);
            player1.winDeck.addCard(firstCard);
        }
        else if(firstCard.getValue() < secondCard.getValue()){
            player2.winDeck.addCard(secondCard);
            player2.winDeck.addCard(firstCard);
        }
        else{

        }

    }
    public void war(Card firstCard, Card secondCard){
        openDeckPlayer1.addCard(firstCard);
        openDeckPlayer2.addCard(secondCard);
        for(int i=0; i<2; i++){
            openDeckPlayer1.addCard(player1.playDeck.removeTopCard());
            openDeckPlayer2.addCard(player2.playDeck.removeTopCard());
        }
        Card warCard1 = player1.playDeck.removeTopCard();
        Card warCard2 = player2.playDeck.removeTopCard();
        if(warCard1.getValue() > warCard2.getValue())
            dealCards(player1);
        else
            dealCards(player2);
    }
}
