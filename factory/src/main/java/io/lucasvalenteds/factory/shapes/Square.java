package io.lucasvalenteds.factory.shapes;

import java.io.PrintStream;

public class Square extends PrintableShape {

    public Square(PrintStream printStream) {
        super(printStream);
    }

    @Override
    public void draw() {
        printStream.print("√9 = 3");
    }
}
