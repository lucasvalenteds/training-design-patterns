package io.lucasvalenteds.factory.shapes;

import java.io.PrintStream;

public class Rectangle extends PrintableShape {

    public Rectangle(PrintStream printStream) {
        super(printStream);
    }

    @Override
    public void draw() {
        printStream.print("Rectangle");
    }
}
