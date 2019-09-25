package io.lucasvalenteds.chain;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Request {
    private final String message;
    private final ConcurrentLinkedQueue<String> contactMethods;

    public Request(String message) {
        this.message = message;
        this.contactMethods = new ConcurrentLinkedQueue<>();
    }

    String getMessage() {
        return message;
    }

    void addContactMethod(String contactMethod) {
        contactMethods.add(contactMethod);
    }

    ConcurrentLinkedQueue<String> getContactMethods() {
        return contactMethods;
    }

    @Override
    public String toString() {
        return String.format("Sending \"%s\" %s", getMessage(), getContactMethods());
    }
}
