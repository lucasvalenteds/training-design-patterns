package io.lucasvalenteds.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private final BigDecimal balance;
    private final List<CashOperation> operations;

    public Account(double initialBalance) {
        this.balance = BigDecimal.ZERO.add(BigDecimal.valueOf(initialBalance));
        this.operations = new ArrayList<>();
    }

    public void executeOperation(CashOperation operation) {
        operations.add(operation);
    }

    public double getBalance() {
        double snapshot = balance.doubleValue();

        for (CashOperation operation : operations) {
            snapshot = operation.execute(snapshot);
        }

        return snapshot;
    }
}
