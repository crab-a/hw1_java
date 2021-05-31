public class Card {
    private final int value;
    private final Shape shape; //need to make sure this is immutable.
    private final String valuename;
    Card(int value,Shape shape){ //maybe add check to see if 1<=value<=13
        this.value = value;
        this.shape = shape;
        if(value<=10){
            this.valuename=Integer.toString(value);
        }
        else
    }
    public int getValue() {return this.value;}
    public Shape getShape() {return this.shape;}
    public int compare(Card other){
        int result = (this.value - other.value);
        if (result!=0){
            result= result/java.lang.Math.abs(result);
        }
        return result;
    }
    @Override
    public String toString() {
        return (this.value + " of " + this.shape);
    }

}
