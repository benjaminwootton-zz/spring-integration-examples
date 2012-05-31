package examples.components;

import java.util.logging.Logger;

public class Barista {

    Logger logger = Logger.getLogger(Barista.class.getName());
    private String name;

    public Barista(String name) {
        this.name = name;
    }

    public void makeCoffee(Object request) {
        logger.info(String.format("%s making coffee order [%s]", name, request.toString()));
    }

}
