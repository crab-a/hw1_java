public class WarGame {
    private Player player1;
    private Player player2;
    private Deck openDeckPlayer1;
    private Deck openDeckPlayer2;
    public WarGame(String nameA, String nameB){
        player1 = new Player(name1);
        player2 = new Player(name2);
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

    }
}
