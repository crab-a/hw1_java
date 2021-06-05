public class WarGame {
    private Player player1;
    private Player player2;
    private Deck openDeckPlayer1;
    private Deck openDeckPlayer2;
    private Card current;
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
        if(play(player1)) openDeckPlayer1.addCard(this.current);
        else gameOver();
        if(play(player2)) openDeckPlayer2.addCard(this.current);
        else gameOver();
        dealCards();
        else
            if(war()) dealCards();
            else gameOver();

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
        else if(warCard1.getValue() < warCard2.getValue())
            dealCards(player2);
        else
            war(warCard1, warCard2);
    }
    private void dealCards(Player winner){
    }
    private boolean play(Player player){
        if(player.playDeck.isEmpty()){
            if(player.winDeck.isEmpty()){
                return false;
            }
            player.winDeck.shuffle();
            Deck tempDeck = new Deck(false);
            while(!player.winDeck.isEmpty()){
                tempDeck.addCard(player.winDeck.removeTopCard());
            }
            while(!tempDeck.isEmpty()){
                player.playDeck.addCard(player.winDeck.removeTopCard());
            }
        }
        this.current = player1.playDeck.removeTopCard();
        return true;
    }
}
