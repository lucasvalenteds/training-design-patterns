package io.lucasvalenteds.factory;

import io.lucasvalenteds.factory.shapes.Shape;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MainTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final ShapeFactory factory = new ShapeFactory(new PrintStream(outputStream));

    static Stream<Arguments> shapes() {
        return Stream.of(
            Arguments.of(ShapeType.Circle, "Drawing a circle"),
            Arguments.of(ShapeType.Rectangle, "Rectangle"),
            Arguments.of(ShapeType.Square, "√9 = 3"),
            Arguments.of(null, "")
        );
    }

    @ParameterizedTest(name = "{0} prints \"{1}\"")
    @MethodSource("shapes")
    void testItCanDrawSomeShape(ShapeType type, String output) {
        Shape shape = factory.getShape(type);

        shape.draw();

        assertEquals(output, outputStream.toString());
    }
}
