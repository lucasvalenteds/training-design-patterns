package io.lucasvalenteds.decorator;

public class Cheese extends Extra {

    Cheese(Order order) {
        super(order);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 3.00;
    }
}
