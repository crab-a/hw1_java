public enum Shape {
    /**
     * the four suits of poker Cards, returns the shape of the card
     */
    SPADES("♠"),
    DIAMONDS("♦"),
    CLUBS("♣"),
    HEARTS("♥");

    Shape(String shape) {
        this.shape = shape;
    }

    private final String shape;

    @Override
    public String toString() {
        return this.shape;
    }
}
