package io.lucasvalenteds.builder;

public class Address {

    private final String street;
    private final int number;
    private final String city;
    private final String state;

    private Address(String street, int number, String city, String state) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    static class Builder {

        public String street;
        public int number;
        public String city;
        public String state;

        Address create() {
            return new Address(street, number, city, state);
        }
    }
}
