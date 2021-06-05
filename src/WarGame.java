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

    }
}
