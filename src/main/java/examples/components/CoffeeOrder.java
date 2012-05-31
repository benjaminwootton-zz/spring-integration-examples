package examples.components;

public class CoffeeOrder {

    private static int orderId = 0;
    private boolean milk = false;
    private boolean sugar = false;

    public CoffeeOrder( boolean milk, boolean sugar ) {
        ++orderId;
        this.milk = milk;
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return String.format( "Order ID => %s, Milk => %s, Sugar => %s", orderId, milk, sugar );
    }
}
