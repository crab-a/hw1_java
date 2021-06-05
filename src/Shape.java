public enum Shape {
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
