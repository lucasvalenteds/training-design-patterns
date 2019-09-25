package io.lucasvalenteds.factory;

import io.lucasvalenteds.factory.shapes.Circle;
import io.lucasvalenteds.factory.shapes.Rectangle;
import io.lucasvalenteds.factory.shapes.Shape;
import io.lucasvalenteds.factory.shapes.Square;
import io.lucasvalenteds.factory.shapes.Unknown;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ShapeFactory {

    private final Map<ShapeType, Supplier<Shape>> shapes = new HashMap<>();
    private final PrintStream printStream;

    public ShapeFactory(PrintStream printStream) {
        this.printStream = printStream;

        shapes.put(ShapeType.Circle, () -> new Circle(printStream));
        shapes.put(ShapeType.Rectangle, () -> new Rectangle(printStream));
        shapes.put(ShapeType.Square, () -> new Square(printStream));
    }

    public Shape getShape(ShapeType type) {
        return shapes.getOrDefault(type, () -> new Unknown(printStream)).get();
    }
}
