package io.lucasvalenteds.factory.shapes;

import java.io.PrintStream;

public abstract class PrintableShape implements Shape {

    protected final PrintStream printStream;

    public PrintableShape(PrintStream printStream) {
        this.printStream = printStream;
    }
}
