package examples.channels;

import examples.components.Americano;
import examples.components.Latte;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.message.GenericMessage;

import java.util.logging.Logger;

public class DatatypeChannelTests {

    static Logger logger = Logger.getLogger(DatatypeChannelTests.class.getName());
    private final static String SPRING_CONTEXT_FILE = "src/test/resources/datatype-channel-example.xml";
    private ApplicationContext applicationContext;

    private DirectChannel latteOnlyChannel;
    private DirectChannel latteConverterChannel;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext(SPRING_CONTEXT_FILE);
        latteOnlyChannel = (DirectChannel) applicationContext.getBean("latteOnlyChannel");
        latteConverterChannel = (DirectChannel) applicationContext.getBean("latteConverterChannel");
    }

    @Test
    public void dataTypeChannelShouldAcceptValidDataType() {
        latteOnlyChannel.send(new GenericMessage(new Latte()));
    }

    @Test
    public void dataTypeChannelShouldNotAcceptInvalidDataType() {
        latteOnlyChannel.send(new GenericMessage(new Americano()));
    }

    @Test
    public void dataTypeChannelShouldConvert() {
        latteConverterChannel.send(new GenericMessage(new Americano()));
    }
}
