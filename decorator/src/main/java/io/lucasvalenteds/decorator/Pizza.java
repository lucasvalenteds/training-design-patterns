package io.lucasvalenteds.decorator;

public class Pizza implements Order {
    @Override
    public double getPrice() {
        return 20.00;
    }
}
