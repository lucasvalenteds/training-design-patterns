package io.lucasvalenteds.command;

import java.math.BigDecimal;

public class Deposit implements CashOperation {

    private final BigDecimal amount;

    public Deposit(double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    @Override
    public double execute(double total) {
        return BigDecimal.valueOf(total)
            .add(amount)
            .doubleValue();
    }
}
