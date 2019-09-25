package io.lucasvalenteds.factory.shapes;

import java.io.PrintStream;

public class Circle extends PrintableShape {

    public Circle(PrintStream printStream) {
        super(printStream);
    }

    @Override
    public void draw() {
        printStream.print("Drawing a circle");
    }
}
