public class Card {
    private final Value value; //need to make sure this is immutable.
    private final Shape shape; //need to make sure this is immutable.

    Card(Value value, Shape shape) { //need to check somewhere that 1<=value<=13
        this.value = value;
        this.shape = shape;
    }

    public int getValue() {
        return this.value.getValue();
    }

    public Shape getShape() {
        return this.shape;
    }

    public int compare(Card other) {
        int result = (this.getValue() - other.getValue());
        if (result != 0) {
            result = result / java.lang.Math.abs(result);
        }
        return result;
    }

    @Override
    public String toString() {
        return (this.value + " of " + this.shape);
    }

}
