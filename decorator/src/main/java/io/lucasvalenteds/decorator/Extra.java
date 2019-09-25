package io.lucasvalenteds.decorator;

public abstract class Extra implements Order {

    private final Order order;

    Extra(Order order) {
        this.order = order;
    }

    @Override
    public double getPrice() {
        return order.getPrice();
    }
}
