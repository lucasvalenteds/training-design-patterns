package io.lucasvalenteds.template;

public abstract class HotDrink {

    protected abstract String addFirstIngredient();

    protected abstract String addSecondIngredient();

    public String prepare() {
        return "Mixing " + addFirstIngredient() + " and " + addSecondIngredient();
    }
}
