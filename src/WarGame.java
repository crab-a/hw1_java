public class WarGame {
    private final Player player1;
    private final Player player2;
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
        System.out.println("Initializing the game...");
        initializeGame();
        int roundCounter=1;
        do {
            System.out.println("------------------------- Round number "+(roundCounter++)+" -------------------------");

        }while (round(false));
        return whoIsTheWinner();
    }

    public boolean round(boolean isWar) {
        if (play(player1)){
            System.out.println(player1+" drew " +this.current);
            openDeckPlayer1.addCard(this.current);
        }
        else return false;
        if (play(player2)){
            System.out.println(player2+" drew " +this.current);
            openDeckPlayer2.addCard(this.current);
        }
        else return false;
        if (dealCards(isWar)) ;
        else if (war()) ;
        else return false;
        return true;
    }
    public boolean war(){
        System.out.println("Starting a war...");
        for(int i=0; i<2; i++) {
            if (play(player1)){
                System.out.println(player1 +" drew a war card");
                openDeckPlayer1.addCard(this.current);
            }
            else return false;
            if (play(player2)){
                System.out.println(player2 +" drew a war card");
                openDeckPlayer2.addCard(this.current);
            }
            else return false;
        }
        return round(true);
    }
    private boolean dealCards(boolean isWar){
        int winner = openDeckPlayer1.getTopCard().compare(openDeckPlayer2.getTopCard());
        switch (winner){
            case 1:
                System.out.print(player1+" won");
                while (!openDeckPlayer1.isEmpty()){
                    player1.addWinDeck(openDeckPlayer1.removeTopCard());
                    player1.addWinDeck(openDeckPlayer2.removeTopCard());
                }
                break;
            case -1:
                System.out.print(player2+" won");
                while (!openDeckPlayer1.isEmpty()) {
                    player2.addWinDeck(openDeckPlayer1.removeTopCard());
                    player2.addWinDeck(openDeckPlayer2.removeTopCard());
                }
                break;
            default:
                return false;
        }
        if (isWar) System.out.println(" the war");
        else System.out.println();
        return true;
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
                player.addPlayDeck(tempDeck.removeTopCard());
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
