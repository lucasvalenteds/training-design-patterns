package io.lucasvalenteds.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalAccount {

    private final BigDecimal balance;
    private final List<Function<Double, Double>> operations;

    public FunctionalAccount(double initialBalance) {
        this.balance = BigDecimal.ZERO.add(BigDecimal.valueOf(initialBalance));
        this.operations = new ArrayList<>();
    }

    public void executeOperation(Function<Double, Double> operation) {
        operations.add(operation);
    }

    public double getBalance() {
        double snapshot = balance.doubleValue();

        for (Function<Double, Double> operation : operations) {
            snapshot = operation.apply(snapshot);
        }

        return snapshot;
    }
}
