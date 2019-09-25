package io.lucasvalenteds.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testOrderHasPrice() {
        Order order = new Pizza();

        assertEquals(20.00, order.getPrice(), 0.01);
    }

    @Test
    void testOrdersMayHaveExtraCheese() {
        Order order = new Cheese(new Pizza());

        assertEquals(23.00, order.getPrice(), 0.01);
    }

    @Test
    void testOrdersMayHaveBacon() {
        Order order = new Bacon(new Pizza());

        assertEquals(23.50, order.getPrice(), 0.01);
    }

    @Test
    void testOrderMayHaveBaconAndDoubleCheese() {
        Order order = new Bacon(new Cheese(new Cheese(new Pizza())));

        assertEquals(29.50, order.getPrice(), 0.01);
    }
}
