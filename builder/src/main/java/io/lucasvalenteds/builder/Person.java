package io.lucasvalenteds.builder;

import java.time.LocalDate;
import java.util.function.Consumer;

class Person {

    private final String name;
    private final LocalDate birthday;
    private final Address address;

    private Person(String name, LocalDate birthday, Address address) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Address getAddress() {
        return address;
    }

    static class Builder {

        public String name;
        public LocalDate birthday;
        private Address address;

        public Person.Builder details(Consumer<Person.Builder> builderFn) {
            builderFn.accept(this);
            return this;
        }

        public Person.Builder address(Consumer<Address.Builder> builderFn) {
            Address.Builder builder = new Address.Builder();
            builderFn.accept(builder);
            address = builder.create();
            return this;
        }

        public Person build() {
            return new Person(name, birthday, address);
        }
    }

}
