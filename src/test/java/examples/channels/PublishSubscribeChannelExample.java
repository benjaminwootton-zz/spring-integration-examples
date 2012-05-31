package examples.channels;

import examples.components.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;
import java.util.logging.Logger;

public class PublishSubscribeChannelExample {

    static Logger logger = Logger.getLogger(PublishSubscribeChannelExample.class.getName());
    private final static String SPRING_CONTEXT_FILE = "src/test/resources/publish-subscribe-channel-example.xml";

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(SPRING_CONTEXT_FILE);
        Customer customer = (Customer) applicationContext.getBean("customer");
        repeatedlyPlaceCustomerOrders(customer);
    }

    private static void repeatedlyPlaceCustomerOrders(Customer customer) throws InterruptedException {
        Random random = new Random();
        while (true) {
            customer.placeOrder();
            Thread.sleep(random.nextInt(10) * 1000L);
        }
    }
}
