public class WarGame {
    private Player player1;
    private Player player2;
    private Deck openDeckPlayer1;
    private Deck openDeckPlayer2;
    private Card current;

    public WarGame(String nameA, String nameB) {
        String firstPlayer = nameA;
        String secondPlayer = nameB;
        if (nameA.compareTo(nameB) > 0) {
            firstPlayer = nameB;
            secondPlayer = nameA;
        }
        player1 = new Player(firstPlayer);
        player2 = new Player(secondPlayer);
        openDeckPlayer1 = new Deck(false);
        openDeckPlayer2 = new Deck(false);
    }

    public void initializeGame() {
        Deck initDeck = new Deck(true);
        initDeck.shuffle();
        int counter = 0;
        while (!initDeck.isEmpty()) {
            Player[] playerArr = {player1, player2};
            playerArr[counter % 2].addPlayDeck(initDeck.removeTopCard());
            counter++;
        }
    }

    public String start() {
        initializeGame();
        while (round());
        return whoIsTheWinner();
    }

    public boolean round() {
        if (play(player1)) openDeckPlayer1.addCard(this.current);
        else return false;
        if (play(player2)) openDeckPlayer2.addCard(this.current);
        else return false;
        if (dealCards()) ;
        else if (war()) ;
        else return false;
        return true;
    }
    public boolean war(){
        for(int i=0; i<3; i++) {
            if (play(player1)) openDeckPlayer1.addCard(this.current);
            else return false;
            if (play(player2)) openDeckPlayer2.addCard(this.current);
            else return false;
        }
        if (dealCards()) return true;
        else if(war()) return true;
        else return false;
    }
    private boolean dealCards(){
        int firstCard=openDeckPlayer1.getTopCard().getValue();
        int secondCard=openDeckPlayer2.getTopCard().getValue();
        if (firstCard>secondCard){
            while (!openDeckPlayer1.isEmpty()){
                player1.addWinDeck(openDeckPlayer1.removeTopCard());
                player1.addWinDeck(openDeckPlayer2.removeTopCard());
            }
            return true;
        }
        if (firstCard<secondCard) {
            while (!openDeckPlayer1.isEmpty()) {
                player2.addWinDeck(openDeckPlayer1.removeTopCard());
                player2.addWinDeck(openDeckPlayer2.removeTopCard());
            }
            return true;
        }
        return false;
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
        this.current = player.drawCard();
        return true;
    }
    private String whoIsTheWinner(){
        if(player1.outOfCards())
            return player2.getName();
        else return player1.getName();
    }
}
