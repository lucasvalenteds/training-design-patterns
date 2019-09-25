package io.lucasvalenteds.strategy;

import java.io.PrintStream;

public class HelpDesk {

    private final PrintStream printStream;

    public HelpDesk(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void sendMessage(Customer customer, ContactMethod contactMethod) {
        try {
            printStream.print("Hello " + customer.getName() + " " + contactMethod.contact(customer));
        } catch (RuntimeException exception) {
            printStream.print(exception.getMessage());
        }
    }
}
