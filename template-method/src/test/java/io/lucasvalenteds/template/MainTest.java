package io.lucasvalenteds.template;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {

    static Stream<Arguments> fixtures() {
        return Stream.of(
            Arguments.of(new Latte(), "Mixing Milk and Coffee powder"),
            Arguments.of(new BlackCoffee(), "Mixing Water and Coffee powder")
        );
    }

    @ParameterizedTest
    @MethodSource("fixtures")
    void testItCanPrepareHotDrink(HotDrink drink, String message) {
        assertEquals(message, drink.prepare());
    }
}
