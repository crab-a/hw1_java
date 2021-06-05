public class Card {
    private final Value value; //need to make sure this is immutable.
    private final Shape shape; //need to make sure this is immutable.

    Card(Value value, Shape shape) { //need to check somewhere that 1<=value<=13
        this.value = value;
        this.shape = shape;
    }

    public Value getValue() {
        return this.value;
    }

    public Shape getShape() {
        return this.shape;
    }

    public int compare(Card other) {
        int result = (this.value.getValue() - other.value.getValue());
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
