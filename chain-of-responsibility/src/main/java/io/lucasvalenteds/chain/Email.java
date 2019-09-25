package io.lucasvalenteds.chain;

class Email extends NotificationChain {

    Email(NotificationHandler next) {
        super(next);
    }

    @Override
    public void handle(Request request) {
        request.addContactMethod("E-mail");
        dispatch(request);
    }
}
