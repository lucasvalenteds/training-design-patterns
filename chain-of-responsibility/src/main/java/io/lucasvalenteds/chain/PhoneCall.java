package io.lucasvalenteds.chain;

class PhoneCall extends NotificationChain {

    PhoneCall(NotificationHandler next) {
        super(next);
    }

    @Override
    public void handle(Request request) {
        request.addContactMethod("Phone call");
        dispatch(request);
    }
}
