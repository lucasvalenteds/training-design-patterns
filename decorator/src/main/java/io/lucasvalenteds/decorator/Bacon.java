package io.lucasvalenteds.decorator;

public class Bacon extends Extra {

    Bacon(Order order) {
        super(order);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 3.50;
    }
}
