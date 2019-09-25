package io.lucasvalenteds.chain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testItCanSendMessageViaEmail() {
        Request request = new Request("Hello John");

        NotificationHandler handler = new Email(null);
        handler.handle(request);

        assertEquals("Sending \"Hello John\" [E-mail]", request.toString());
    }

    @Test
    void testItCanSendMessageViaPhoneCall() {
        Request request = new Request("Hello Mary");

        NotificationHandler handler = new PhoneCall(null);
        handler.handle(request);

        assertEquals("Sending \"Hello Mary\" [Phone call]", request.toString());
    }

    @Test
    void testItCanSendToBoth() {
        Request request = new Request("Happy birthday!");

        NotificationHandler email = new Email(null);
        NotificationHandler phone = new PhoneCall(email);
        phone.handle(request);

        assertEquals("Sending \"Happy birthday!\" [Phone call, E-mail]", request.toString());
    }
}