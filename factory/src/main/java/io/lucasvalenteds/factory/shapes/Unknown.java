package io.lucasvalenteds.factory.shapes;

import java.io.PrintStream;

public class Unknown extends PrintableShape {

    public Unknown(PrintStream printStream) {
        super(printStream);
    }

    @Override
    public void draw() {
        printStream.print("");
    }
}
