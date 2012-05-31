package examples.components;

import java.util.Random;
import java.util.logging.Logger;

public class Customer {

    Logger logger = Logger.getLogger(Customer.class.getName());
    private OrderManager orderManager;

    public Customer(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public void placeOrder() {
        CoffeeOrder coffeeOrder = generateRandomCoffeeOrder();
        logger.info(String.format("Placing customer order [%s]", coffeeOrder));
        orderManager.send(coffeeOrder);
    }

    private CoffeeOrder generateRandomCoffeeOrder() {
        Random random = new Random();
        boolean milk = random.nextLong() < 0.5;
        boolean sugar = random.nextLong() < 0.5;
        return new CoffeeOrder(milk, sugar);
    }
}
