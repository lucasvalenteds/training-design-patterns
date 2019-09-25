package io.lucasvalenteds.chain;

import java.util.Optional;

abstract class NotificationChain implements NotificationHandler {

    private final NotificationHandler next;

    NotificationChain(NotificationHandler next) {
        this.next = next;
    }

    void dispatch(Request request) {
        Optional.ofNullable(next).ifPresent(it -> next.handle(request));
    }
}
