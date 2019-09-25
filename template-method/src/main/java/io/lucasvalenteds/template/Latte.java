package io.lucasvalenteds.template;

public class Latte extends HotDrink {

    @Override
    protected String addFirstIngredient() {
        return "Milk";
    }

    @Override
    protected String addSecondIngredient() {
        return "Coffee powder";
    }
}
