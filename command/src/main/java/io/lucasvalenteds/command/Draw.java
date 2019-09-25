package io.lucasvalenteds.command;

import java.math.BigDecimal;

public class Draw implements CashOperation {

    private double amount;

    public Draw(double amount) {
        this.amount = amount;
    }

    @Override
    public double execute(double total) {
        return BigDecimal.valueOf(total)
            .subtract(BigDecimal.valueOf(amount))
            .doubleValue();
    }
}
