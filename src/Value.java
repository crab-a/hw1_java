public enum Value {
    ACE(1,"Ace"), N2(2,"2"), N3(3,"3"), N4(4,"4"), N5(5,"5"), N6(6,"6"),
    N7(7,"7"), N8(8,"8"), N9(9,"9"), N10(10,"10"),
    JACK(11,"Jack"), QUEEN(12,"Queen"), KING(13,"King");
    Value(int value, String name) {
        this.value = value;
        this.name=name;
    }

    private final int value;
    private final String name;

    public int getValue() {return this.value;}
    @Override
    public String toString() {return name;}
}