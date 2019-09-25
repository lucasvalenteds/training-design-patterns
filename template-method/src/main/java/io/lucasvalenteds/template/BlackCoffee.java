package io.lucasvalenteds.template;

public class BlackCoffee extends HotDrink {
    @Override
    protected String addFirstIngredient() {
        return "Water";
    }

    @Override
    protected String addSecondIngredient() {
        return "Coffee powder";
    }
}
