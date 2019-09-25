package io.lucasvalenteds.strategy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class MainTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final HelpDesk helpDesk = new HelpDesk(new PrintStream(outputStream));

    @Test
    void testValidEmail() {
        Customer john = new Customer("John", "john.smith@gmail.com", null);

        helpDesk.sendMessage(john, new Email());

        assertEquals("Hello John (Sent via e-mail)", outputStream.toString());
    }

    @Test
    void testInvalidEmail() {
        Customer john = new Customer("John", null, null);

        helpDesk.sendMessage(john, new Email());

        assertEquals("Customer does not have a known e-mail", outputStream.toString());
    }

    @Test
    void testValidPhone() {
        Customer john = new Customer("John", null, "(555) 555-1234");

        helpDesk.sendMessage(john, new SMS(null));

        assertEquals("Hello John (Sent via SMS)", outputStream.toString());
    }

    @Test
    void testInvalidValidPhoneUsesEmailAsFallback() {
        Customer john = new Customer("John", "john.smith@gmail.com", null);

        helpDesk.sendMessage(john, new SMS(new Email()));

        assertEquals("Hello John (Sent via e-mail)", outputStream.toString());
    }

}
