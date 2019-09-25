package io.lucasvalenteds.strategy;

import java.util.Optional;

public class Email implements ContactMethod {
    @Override
    public String contact(Customer customer) {
        return Optional.ofNullable(customer.getEmail())
            .map(it -> "(Sent via e-mail)")
            .orElseThrow(() -> new RuntimeException("Customer does not have a known e-mail"));
    }
}
