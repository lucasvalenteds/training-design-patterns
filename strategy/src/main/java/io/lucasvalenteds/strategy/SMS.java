package io.lucasvalenteds.strategy;

import java.util.Optional;

public class SMS implements ContactMethod {

    private final ContactMethod fallback;

    public SMS(ContactMethod fallback) {
        this.fallback = fallback;
    }

    @Override
    public String contact(Customer customer) {
        return Optional.ofNullable(customer.getPhone())
            .map(it -> "(Sent via SMS)")
            .orElseGet(() -> fallback.contact(customer));
    }
}
